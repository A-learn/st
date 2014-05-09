package mutisec;
//{ {'H','A','R','P','S'},
//	{ 'I','C','O','D','B'},
//	{ 'E','F','G','K','L'},
//	{ 'M','N','Q','T','U'},
//	{ 'V','W','X','Y','Z'}};
//RS WO FW KS IF KLQU//
//CX CN CN PL 
public class De2 {
	char mi[][]=Encryption.mi;
	String key="";
	De2(String s){
		String xx="";
		int len=s.length();
		int c=0;
		if(s.length()%2!=0){
			System.out.println("not a Ciphertext");
		}
		for(int i=0;i<len;i++){
			
			if((i+1)%2==0&&i>0){
			 xx=s.substring(c,i+1);
				c=i+1;
				retra(xx);
				
				//System.out.println(xx);
			}
			
		}
		//System.out.println(key);
		for(int j=0;j<key.length();j++){
			if(j>=key.length()-1)
				break;
			if(key.substring(j,j+1).equals("X")){
				if(key.substring(j-1,j).equals(key.substring(j+1,j+2)))
				{
					key=key.substring(0,j)+""+key.substring(j+1);
				}
			}
		}
		System.out.println("©ú¤å: "+key);
	}
	public void retra(String xx) {
		// TODO Auto-generated method stub
		String row="",col="";
		int r1 = -1,r2=-1,r3=-1,c1=-1,c2=-1,c3=-1;
		boolean findrow=false, findcol=false,rec=false,st1=false;
		
		
		

		for(int i=0;i<5;i++)
		{	for(int j=0;j<5;j++)
			{	if(mi[i][j]==xx.charAt(0)&&findrow==false)//row
				{   
					r3=i;
					r1=j;
					findrow=true;
					rec=true;
					
				}
			}	
		}
		
			for(int k=0;k<5;k++)
			{	if(mi[r3][k]==xx.charAt(1)&&findrow==true)//row  
				{	 r2=k;
					row=mi[r3][(r1+4)%5]+""+mi[r3][(k+4)%5];
					findrow=false;
					r1=-1;
					r2=-1;
					//System.out.println("row= "+row);
					
					key=key+row;
					st1=true;
					break;
				}
			if(mi[k][r1]==xx.charAt(1)&&findrow==true)//col
			   {
			   col=mi[(r3-1)%5][r1]+""+mi[(k-1)%5][r1];
			   findcol=false;
			   c1=c2=c3=-1;
			   //System.out.println(" col= "+col);
			   key=key+col;
			   st1=true;
			   break;
			   		
			   }


			 
			 
			 
		    }//for(k)
			if(st1!=true){
			 step2(xx,r3,r1);
			
			   findrow=false;
			}
				   
		}
		
		
		


	public void step2(String xx,int i,int j) {
		// TODO Auto-generated method stub
		String dia="";
		boolean don=false;
		int cc=0;
		int i1=i,j1=j;
	for(int s=0;s<5&&don==false;s++)
		{ 
		for(int k=0;k<5&&don==false;k++){
				if(mi[s][k]==xx.charAt(1))
				{
					dia=mi[s][j1]+""+mi[i1][k];
					//System.out.println("sqr= "+dia);
					cc++;
					key=key+dia;
					don=true;
				}
				
			 }
		
		}
		//System.out.println(dia);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//De2 p = new De2("ODHTMUHG");
		/*Decode p1 = new Decode("RSWOFWKSIFKLQU");*/
	}

}
