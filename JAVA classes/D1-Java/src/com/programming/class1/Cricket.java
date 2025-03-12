package com.programming.class1;

public class Cricket implements IndianSports {
	
	String Hname , Vname ;
	int Hscore=0;
	int Ascore=0;
	
	public void setHomeTScore(int pts ) {
		this.Hscore += pts;
	}

	@Override
	public void setHomeTName(String name) {
		// TODO Auto-generated method stub
		this.Hname=name;
		
	}
	
	@Override
	public void setAwayTName(String name) {
		// TODO Auto-generated method stub
		this.Vname=name;
		
	}

	@Override
	public void setAwayTScore(int pts) {
		this.Ascore += pts;
		
	}
	
}
