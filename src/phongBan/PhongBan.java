package phongBan;

public class PhongBan {
    private	String maPB;
    private String tenPB;
    
    public PhongBan() {
		// TODO Auto-generated constructor stub
	}
    
	
	public PhongBan(String maPB, String tenPB) {
		super();
		this.setMaPB(maPB);
		this.tenPB = tenPB;
	}
 

	public PhongBan(String maPB) {
		super();
		this.setMaPB(maPB);
	} 


	public String getTenPB() {
		return tenPB;
	}
	public void setTenPB(String tenPB) {
		this.tenPB = tenPB;
	}
	
	
	

	@Override
	public String toString() {
		return String.format("%s,%s", getMaPB(), getTenPB());
	}


	public String getMaPB() {
		return maPB;
	}


	public void setMaPB(String maPB) {
		this.maPB = maPB;
	}
	
	
	

}

