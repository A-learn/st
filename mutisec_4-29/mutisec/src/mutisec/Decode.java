package mutisec;
//{ {'H','A','R','P','S'},
//	{ 'I','C','O','D','B'},
//	{ 'E','F','G','K','L'},
//	{ 'M','N','Q','T','U'},
//	{ 'V','W','X','Y','Z'}};
//RS WO FW KS IF KLQU//
//CX CN CN PL 
public class Decode {
	char mi[][]=Encryption.mi;
	String key="";
	Decode(String s){
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
		System.out.println(key);
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
		boolean findrow=false,findcol=false,test=false;
		int r1=-1,r2=-1,r3=-1,c1=-1,c2=-1,c3=-1;
		String row="",col="";
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++)
			{
				if(mi[i][j]==xx.charAt(0)&&findrow==false)//row
				{   r1=j;
					r3=i;
					findrow=true;
					
				}
				if(mi[j][i]==xx.charAt(0)&& findcol==false)//col
				{
					c1=j;
					c3=i;
					findcol=true;
					
				}
			}
			for(int k=0;k<5;k++)
			{
				if(mi[i][k]==xx.charAt(1)&&r3==i)//row  
				  {	r2=k;
					row=mi[i][(r1+4)%5]+""+mi[i][(r2+4)%5];
					findrow=false;
					r1=-1;
					r2=-1;
					//System.out.println(row+" row");
					key=key+row;
					test=true;
					//break;
				}
				if(mi[k][i]==xx.charAt(1)&&findcol==true&&c3==i)//col
				   { c2=k;
				   	 col=mi[(c1+4)%5][i]+""+mi[(c2+4)%5][i];
				   	 findcol=false;
				   	 c1=-1;
				   	 c2=-1;
				   	 //System.out.println(col+" col");
				   	 //System.out.println(xx+" col ");
				   	 key=key+col;
				   	test=true;
				   	// break;
				   }
				else  if(findrow==true&&r3==i&&k==4&&test==false)
				{
					step2(xx,r3,r1);
					findrow=false;
					r3=-1;
					r1=-1;
					
					//System.out.println(xx+" step2 ");
				}
			}
		}
	}
	public void step2(String xx, int i, int j) {
		// TODO Auto-generated method stub
		String dia="";
		boolean don=false;
		int cc=0;
	for(int s=0;s<5&&don==false;s++)
		{ 
		for(int k=0;k<5&&don==false;k++){
				if(mi[s][k]==xx.charAt(1))
				{
					dia=mi[s][j]+""+mi[i][k];
					//System.out.println(dia+""+cc);
					cc++;
					key=key+dia;
					don=true;
					
				}
				
			 }
		
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Decode p = new Decode("ODHTMUHG");
		Decode p1 = new Decode("RSWOFWKSIFKLQU");
	}

}
