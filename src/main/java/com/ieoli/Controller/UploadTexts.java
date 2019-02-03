package com.ieoli.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import com.ieoli.entity.TextEntity;
import com.ieoli.service.ModelService;
import com.ieoli.service.TextsService;
@Controller
public class UploadTexts {
	@Resource TextsService tService;
	@Resource
	ModelService ms;
	  @RequestMapping("/UploadTexts")
	    public void  springUpload(HttpServletRequest request,HttpSession session,HttpServletResponse response) throws IllegalStateException, IOException
	    {
		  if (request.getCharacterEncoding() == null) {
			  request.setCharacterEncoding("UTF-8");//你的编码格式
			  }

		 // String modelid = request.getParameter("models");
		 // int id = Integer.parseInt(modelid);
	        	         //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
	        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
	                request.getSession().getServletContext());
	        //检查form中是否有enctype="multipart/form-data"
	        if(multipartResolver.isMultipart(request))
	        {
	            //将request变成多部分request
	            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
	           //获取multiRequest 中所有的文件名
	            Iterator<String> iter=multiRequest.getFileNames();
	             
	            while(iter.hasNext())
	            {
	                //一次遍历所有文件
	            	List<MultipartFile> fileList=multiRequest.getFiles(iter.next());  
	            	if(fileList.size()>0)
	            	{
	            		Iterator<MultipartFile> fileite=fileList.iterator();  
	            		while(fileite.hasNext())
	            		{
	            			 MultipartFile file=fileite.next();  
	            			 long t1= System.currentTimeMillis();
	            			 String path = session.getServletContext().getRealPath("/")+"texts\\"+file.getOriginalFilename();
	 	                	File f =new File(path);
	 	                	file.transferTo(f);
	 	                	TextEntity te = new TextEntity();
	 	     
                	    	//te.setModelid(id);
                	    	te.setTextname(file.getOriginalFilename());
                	    	BufferedReader reader = null;
                	    	String allString = "";
                	    	try {

                	    	FileInputStream fis = new FileInputStream(f);
								reader = new BufferedReader(new InputStreamReader(fis,"utf-8"));

								String tempString = null;
								tempString = reader.readLine();
								if(tempString!=null)
								{
									if(tempString.contains(" ")||tempString.equals(""))
									{
										do{
											if(tempString.equals(""))
											{
												allString+="/p$";
											}else {
												String[] arr= tempString.split(" ");
												for(String ar:arr)
												{
													allString+=ar+"$";
												}
											}
										}while((tempString =reader.readLine())!=null);
									}else {
										do{
											//tempString = new String(tempString.getBytes("GBK"),"utf-8");
											if(tempString.equals(""))//段落
											{
												allString+="/p$";
											}else {
												allString+=tempString+"$";
											}
										}while((tempString =reader.readLine())!=null);
									}
								}

	                	    	te.setArticle(allString);
	                	    	te.setOnline(0);
	                	    	tService.insertFile(te);
								reader.close();
								
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
								System.out.println(allString.length());
							}finally{
								if(reader!=null)
								{
									 try {
						                    reader.close();
						                } catch (IOException e1) {
						                }
								}
							}
	 	                	 System.out.println(path);
	            		}
	            		
	            	}
	            }
	           
	        }
	      //  ModelAndView mav = new ModelAndView();
	       // mav.setViewName("/WEB-INF/jsp/upload-texts.jsp");
	       // List<ModelEntity> lists = ms.getModels();
		//	mav.addObject("list", lists);
	//		mav.addObject("sus", "上传成功");
		response.getOutputStream().write("success".getBytes("utf-8"));
	    }                                                                                                                   
}
