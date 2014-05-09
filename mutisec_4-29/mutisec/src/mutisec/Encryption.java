package mutisec;



public class Encryption {
	
static char[][] mi= {{'H','A','R','P','S'},
					{ 'I','C','O','D','B'},
					{ 'E','F','G','K','L'},
					{ 'M','N','Q','T','U'},
					{ 'V','W','X','Y','Z'}};
private String key="";

public Encryption(String s) {
	int c=0;
	String yy=s;
	String xx="";
	int len=yy.length();
	yy=yy.replace('J','I' );
	
	for(int j=0;j<len;j+=2){
		if(j==len-1)break;
		if(yy.substring(j,j+1).equals(yy.substring(j+1,j+2))){
			 yy=yy.substring(0,j+1)+'X'+yy.substring(j+1);
			len=len+1;
		}
		
	}
	if(len%2!=0){
		yy=yy+'X';
		len++;
	}
	for(int i=0;i<len;i++){
		//if(i<5)
		//System.out.print(mi[i].charAt(1));
		
		
		
		if((i+1)%2==0&&i>0){
		 xx=yy.substring(c,i+1);
			c=i+1;
			sar(xx);
			//System.out.println(xx);
		}
		
	}
	
	//System.out.println(xx);
	System.out.println("key= "+key);
}




public void sar(String xx)
{String row="",col="";
	int r1 = -1,r2=-1,r3=-1,c1=-1,c2=-1,c3=-1;
	boolean findrow=false, findcol=false,rec=false,st1=false;
	
	
	
//////////////////////////////
	for(int i=0;i<5;i++)
	{	for(int j=0;j<5;j++)
		{	if(mi[i][j]==xx.charAt(0)&&findrow==false)//row
			{   
				r3=i;
				r1=j;
				findrow=true;
				rec=true;
				//System.out.println(mi[i][j]+"------");
			}
		}	
	}
	
		for(int k=0;k<5;k++)
		{	if(mi[r3][k]==xx.charAt(1)&&findrow==true)//row  
			{	 r2=k;
				row=mi[r3][(r1+1)%5]+""+mi[r3][(k+1)%5];
				findrow=false;
				r1=-1;
				r2=-1;
				//System.out.println("row= "+row);
				/*int x1=(mi[i].toString().indexOf(xx.charAt(0))+1%4);
				int x2=(mi[i].toString().indexOf(xx.charAt(1))+1%4);
				row=mi[i][(j+1)%4]+""+mi[i][(j+1)%4];*/
				//System.out.println(row+" row");
				key=key+row;
				st1=true;
				break;
			}
		if(mi[k][r1]==xx.charAt(1)&&findrow==true)//col
		   {
		   col=mi[(r3+1)%5][r1]+""+mi[(k+1)%5][r1];
		   findcol=false;
		   c1=c2=c3=-1;
		  // System.out.println(" col= "+col);
		   key=key+col;
		   st1=true;
		   	break;
		   		
		   }
//		 if(mi[k][i]==xx.charAt(1)&&findcol==true&&c3==i)//col
//		   {c2=k;
//		   col=mi[(c1+1)%5][i]+""+mi[(c2+1)%5][i];
//		   findcol=false;
//		   c1=c2=c3=-1;
//		   System.out.println(" col= "+col);
//		   key=key+col;
//		   st1=true;
//		   	break;
//		   		
//		   }
		
		 
		 
		 
	    }
		if(st1!=true){
		 step2(xx,r3,r1);
		  // System.out.println(r3+","+0+mi[r3][0]);
		   findrow=false;
		}
			   
		}//for(i)
//////////////////
	
	
	


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
	/* Encryption p=new Encryption("QQER");
	 Encryption p2=new Encryption("APCCNPLECGKNT");*/
   /* Encryption p=new Encryption("APCCNPLECGKNT");//APCXCNPLECGKNT
    Encryption p1=new Encryption("COMPUTER");*/
  }

}
