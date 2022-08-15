package congTrinh;

public class CongTrinh {
	private int maCT;
	private String tenCT;
	private String diadiem;
	private String ngayCP;
	private String ngayKC;
	private String ngayHT;
	public CongTrinh() {
		// TODO Auto-generated constructor stub
	}
	public CongTrinh(int maCT, String tenCT, String diadiem, String ngayCP, String ngayKC, String ngayHT) {
		super();
		this.maCT = maCT;
		this.tenCT = tenCT;
		this.diadiem = diadiem;
		this.ngayCP = ngayCP;
		this.ngayKC = ngayKC;
		this.ngayHT = ngayHT;
	}
	
	public CongTrinh(int maCT) {
		super();
		this.maCT = maCT;
	}
	public int getMaCT() {
		return maCT;
	}
	public void setMaCT(int maCT) {
		this.maCT = maCT;
	}
	public String getTenCT() {
		return tenCT;
	}
	public void setTenCT(String tenCT) {
		this.tenCT = tenCT;
	}
	public String getDiadiem() {
		return diadiem;
	}
	public void setDiadiem(String diadiem) {
		this.diadiem = diadiem;
	}
	public String getNgayCP() {
		return ngayCP;
	}
	public void setNgayCP(String ngayCP) {
		this.ngayCP = ngayCP;
	}
	public String getNgayKC() {
		return ngayKC;
	}
	public void setNgayKC(String ngayKC) {
		this.ngayKC = ngayKC;
	}
	public String getNgayHT() {
		return ngayHT;
	}
	public void setNgayHT(String ngayHT) {
		this.ngayHT = ngayHT;
	}
	@Override
	public String toString() {
		return String.format("%d;%s;%s;%s;%s;%s", getMaCT(), getTenCT(), getDiadiem(), getNgayCP(), getNgayKC(), getNgayHT());
	}
	
}
