package com.ieoli.Utils;

public class ResultIndex {
	public int textid;
	public int modelid;
public ResultIndex(int textid,int modelid){
	this.textid = textid;
	this.modelid = modelid;
}
@Override
public boolean equals(Object in)
{
	if(this == in) return true;  
    if(in == null) return false; //能调用这个方法，this肯定不为null，所以不判断this  
    if(this.getClass() != in.getClass()) return false; 
    ResultIndex x = (ResultIndex)in;
	if(this.textid==x.textid&&this.modelid==x.modelid)
	{
		return true;
	}else
	{
		return false;
	}
}
@Override
public int hashCode()
{
	return textid*31+modelid;
}
}
