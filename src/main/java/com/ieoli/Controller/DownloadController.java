package com.ieoli.Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ieoli.Utils.ResultIndex;
import com.ieoli.Utils.ZipUtils;
import com.ieoli.entity.ResultEntity;
import com.ieoli.entity.TextEntity;
import com.ieoli.service.ResultsService;
import com.ieoli.service.TextsService;

@Controller
public class DownloadController {
@Resource
ResultsService rs;
@Resource
TextsService ts;

	@RequestMapping(value="/download")
	public ResponseEntity<byte[]> downloadd(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws IOException{
		String[] model=request.getParameter("models").split(",");
		ArrayList<Integer> ids= new ArrayList<>();
		for(String idstr:model)
		{
			ids.add(Integer.parseInt(idstr));
		}
		//从数据库中调取相应结果
		List<ResultEntity> list= rs.downloadRes(ids);
		if(list.size()==0)
		{
			return null;
		}
		HashMap<Integer, List<ResultEntity>> groupbytextid= new HashMap<>();
		for(ResultEntity res:list)
		{
			if(!groupbytextid.containsKey(res.getTextid()))
			{
				ArrayList<ResultEntity> textres=new ArrayList<>();
				textres.add(res);
				groupbytextid.put(res.getTextid(), textres);
			}else {
				groupbytextid.get(res.getTextid()).add(res);
			}
		}
		ArrayList<Integer> textidList=new ArrayList<>(groupbytextid.keySet());
		List<TextEntity> texts = ts.getTextByIDs(textidList);
		String buildpath =session.getServletContext().getRealPath("/");
		String path = integration(buildpath, groupbytextid, texts);
		String curfilename= buildpath+"\\"+(request.getParameter("models")+".zip");
		ZipUtils.doCompress(path, curfilename);
		File file=new File(curfilename);
		HttpHeaders headers =new HttpHeaders();
	    headers.setContentDispositionFormData("attachment", new String((request.getParameter("models")+".zip").getBytes("UTF-8"),"iso-8859-1")); 
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                headers, HttpStatus.CREATED); 
		/*String filename=request.getParameter("filename");
		int modelid=(Integer)session.getAttribute("model");
		String path=session.getServletContext().getRealPath("/")+ "texts\\"+modelid+"_"+filename;
		File file=new File(path);
		HttpHeaders headers =new HttpHeaders();
		
		String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
	    headers.setContentDispositionFormData("attachment", downloadFielName); 
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                headers, HttpStatus.CREATED); 
*/
    }
	//批量生成文件，返回路径
	public static String integration(String buildpath,HashMap<Integer, List<ResultEntity>> results,List<TextEntity> texts) throws IOException
	{
		String path = buildpath+System.currentTimeMillis();
		File dir= new File(path);
		dir.mkdirs();//创建目录
		for(TextEntity text:texts)//一篇文章生成一个文件
		{
			List<ResultEntity> resu= results.get(text.getTextid());
			String[] words= text.getArticle().split("\\$");
			String models="";
			HashMap<ResultIndex, ResultEntity> map = new HashMap<>();
			for(ResultEntity result:resu)
			{
				ResultIndex index= new ResultIndex(result.getTextid(), result.getModelid());
				map.put(index, result);
			}
			List<ResultEntity> res= new ArrayList<>();
			for(Entry<ResultIndex, ResultEntity> entry:map.entrySet())
			{
				res.add(entry.getValue());
			}
			
			for(ResultEntity result:res)
			{
				String[] labels = result.getLabel().split("\\$");
				models+=result.getModelid()+",";
				ArrayList<String> starts = new ArrayList<>();
				for(String label:labels)
				{
					if(label.contains("s"))
					{
						starts.add(label);
					}
					String[] eachlabel = label.split("&");
					int index = Integer.parseInt(eachlabel[0]);
					for(int i =1 ; i<eachlabel.length;i++)
					{
						words[index-1]+=("&"+eachlabel[i]);
					}
				}
				for(String startlabel:starts)
				{
					String[] eachlabel = startlabel.split("&");
					int index = Integer.parseInt(eachlabel[0]);
					String label = eachlabel[1].substring(0,eachlabel[1].length()-1);
					for(String endlabel:labels)
					{
						if(endlabel.contains("p"))
						{
							String[] eachend= endlabel.split("&");
							int endindex = Integer.parseInt(eachend[0]);
							String endl=eachend[1].substring(0,eachend[1].length()-1);
							if(endindex>index&&endl.equals(label))
							{
								for( int i = index+1; i <endindex;i++)
								{
									words[i-1]+=("&"+endl+"m");
								}
							}
						}
					}
				}
			}
			String filename="\\"+models+"_"+text.getTextname();
			StringBuffer sb= new StringBuffer();
			for(String word:words)
			{
				sb.append(word+"\n");
			}
			File textFile=new File(path+filename);
			textFile.createNewFile();
			FileOutputStream outputStream = new FileOutputStream(textFile);
			BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"utf-8"));
			bufferedWriter.write(sb.toString());
			bufferedWriter.close();
			outputStream.close();
		}
		return path;
	}

}
