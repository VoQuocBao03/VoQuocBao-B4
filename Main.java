package baithuchanhb4;


import java.util.Scanner;
import java.util.ArrayList;

class giaoDich{

    @Override
    public String toString() {
        return "giaoDich [maGD=" + maGD + ", ngayGD=" + ngayGD + ", donGia=" + donGia + ", dienTich=" + dienTich + "]";
    }

    private String maGD, ngayGD;
    private Double donGia, dienTich;

    Scanner sc = new Scanner(System.in);

    public giaoDich(){super();}
    public giaoDich(String maGD, String ngayGD, Double donGia, Double dienTich){
        super();
        this.maGD = maGD;
        this.ngayGD = ngayGD;
        this.donGia = donGia;
        this.dienTich = dienTich;
    }
    public String getMaGD() {
        return maGD;
    }
    public void setMaGD(String maGD) {
        this.maGD = maGD;
    }
    public String getNgayGD() {
        return ngayGD;
    }
    public void setNgayGD(String ngayGD) {
        this.ngayGD = ngayGD;
    }
    public Double getDonGia() {
        return donGia;
    }
    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }
    public Double getDienTich() {
        return dienTich;
    }
    public void setDienTich(Double dienTich) {
        this.dienTich = dienTich;
    }

    public void nhap(){
        System.out.println("nhap ma giao dich cua ban: ");
        maGD = sc.nextLine();
        System.out.println("nhap ngay giao dich(ngay/thang/nam): ");
        ngayGD = sc.nextLine();
        System.out.println("nhap don gia cua ban: ");
        donGia = sc.nextDouble();
        System.out.println("nhap dien tich: ");
        dienTich = sc.nextDouble();
    } 
}

class giaodichdat extends giaoDich{
    @Override
    public String toString() {
        return "giaodichdat [loaiDat=" + loaiDat + "]";
    }

    private String loaiDat;

    public giaodichdat(){
       super();
    }
    public giaodichdat(String loaiDat){
        super();
        this.loaiDat = loaiDat;
    }
    public String getLoaiDat() {
        return loaiDat;
    }
    public void setLoaiDat(String loaiDat) {
        this.loaiDat = loaiDat;
    }

    public void nhap(){
        super.nhap();
        System.out.println("nhap loai dat (A/B/C): ");
        loaiDat = sc.nextLine();
    }
}

class giaodichnha extends giaoDich{
    @Override
    public String toString() {
        return "giaodichnha [loaiNha=" + loaiNha + ", diaChi=" + diaChi + "]";
    }

    private String loaiNha, diaChi;
    private int Chon;

    public giaodichnha(){
        super();
    }
    public giaodichnha(String loaiNha, String diaChi){
        super();
        this.loaiNha = loaiNha;
        this.diaChi = diaChi;
    }
    public String getLoaiNha() {
        return loaiNha;
    }
    public void setLoaiNha(String loaiNha) {
        this.loaiNha = loaiNha;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void nhap(){
        super.nhap();
        System.out.println("nhap dia chi cua ban: ");
        diaChi = sc.nextLine();
        System.out.println("nhap loai nha(1: nha cao cap, 2: nha thuong): ");
        loaiNha = sc.nextLine();
    
    switch(Chon){
        case 1: 
            loaiNha = "cao cap";
            break;
        case 2: 
            loaiNha = "thuong";
            break;
        default:
            System.out.println("chon so khong hop le!!!!");
        }
    }     
}

class Main{
    public static void main(String[] args){
        ArrayList<giaodichnha> arrgiaodichnha = new ArrayList<>();
        ArrayList<giaodichdat> arrgiaodichdat = new ArrayList<>();
        int sogiaodichdat = 0, sogiaodichnha = 0;
        long tongtiengiaodichdat = 0, trungbinhthanhtien = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("nhap so giao dich dat: ");
        sogiaodichdat = sc.nextInt();
        System.out.println("nhap so giao dich nha: ");
        sogiaodichnha = sc.nextInt();

        System.out.println("----NHAP THONG TIN GIAO DICH DAT----");
        for (int i = 0; i < sogiaodichdat; i++) {
            System.out.println("nhap thong tin giao dich dat thu " +( i + 1));
            giaodichdat gdd = new giaodichdat();
            gdd.nhap();
            arrgiaodichdat.add(gdd);
        }


        System.out.println("----NHAP THONG TIN GIAO DICH NHA----");
        for (int i = 0; i < sogiaodichnha; i++) {
            System.out.println("nhap thong tin giao dich nha thu " +( i + 1));
            giaodichnha gdn = new giaodichnha();
            gdn.nhap();
            arrgiaodichnha.add(gdn);
        }


        for(int i = 0; i < arrgiaodichdat.size(); i++){
            if(arrgiaodichdat.get(i).getLoaiDat().equalsIgnoreCase("A")){
                tongtiengiaodichdat += arrgiaodichdat.get(i).getDienTich() * arrgiaodichdat.get(i).getDonGia() * 1.5;
            } else if (arrgiaodichdat.get(i).getLoaiDat().equalsIgnoreCase("B") ||
            arrgiaodichdat.get(i).getLoaiDat().equalsIgnoreCase("C")) {
                tongtiengiaodichdat += arrgiaodichdat.get(i).getDienTich() * arrgiaodichdat.get(i).getDonGia();
            }

        trungbinhthanhtien = tongtiengiaodichdat / (arrgiaodichdat.size());
        System.out.println("trung binh thanh tien cua giao dich dat = " + trungbinhthanhtien);

        System.out.println("cac giao dich dat cua thang 9 nam 2023: ");
        for (i = 0; i < arrgiaodichdat.size(); i++){
            String[] dategiaodichdat = arrgiaodichdat.get(i).getNgayGD().split("/");
            if (dategiaodichdat[1].equals("9") && dategiaodichdat[2].equals("2013")){
                System.out.println(arrgiaodichdat.get(i).toString());
            }
        }

        System.out.println("cac giao dich nha cua thang 9 nam 2023: ");
        for (i = 0; i < arrgiaodichnha.size(); i++){
            String[] dategiaodichnha = arrgiaodichnha.get(i).getNgayGD().split("/");
            if (dategiaodichnha[1].equals("9") && dategiaodichnha[2].equals("2013")){
                System.out.println(arrgiaodichnha.get(i).toString());
            }
        }

        }
    }
}


