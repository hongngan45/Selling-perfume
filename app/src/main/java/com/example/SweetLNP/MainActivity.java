package com.example.SweetLNP;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter  adapter1, adapter2, adapter3, adapter4, adapter5;
    private RecyclerView  recyclerViewPopularList1, recyclerViewPopularList2, recyclerViewPopularList3, recyclerViewPopularList4, recyclerViewPopularList5;
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.textView5);

        Intent i = getIntent();
        String user=i.getStringExtra("user");
        username.setText(user);//Hiển thị tên đăng nhập

        recyclerViewPopular1();
        recyclerViewPopular2();
        recyclerViewPopular3();
        recyclerViewPopular4();
        recyclerViewPopular5();

        bottomNavigation();
    }

    private void bottomNavigation() {
        FloatingActionButton giohang = findViewById(R.id.giohang);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout hoadon = findViewById(R.id.hoadon);
        ImageView thongtin = findViewById(R.id.thongtin);

        giohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                String user=i.getStringExtra("user");

                Intent intent  = new Intent(getApplicationContext(), GioHang.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                String user=i.getStringExtra("user");

                Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });

        hoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                String user=i.getStringExtra("user");

                Intent intent  = new Intent(getApplicationContext(), Hoadon.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });

        thongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                String user=i.getStringExtra("user");

                Intent intent  = new Intent(getApplicationContext(), Thongtincanhan.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }

    //    dolce&ga
    private void recyclerViewPopular1() {//Thêm dữ liệu vào mảng và hiển thị ra màn hình

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList1 = findViewById(R.id.recyclerView2);
        recyclerViewPopularList1.setLayoutManager(linearLayoutManager);

        ArrayList<SanPham> splist = new ArrayList<>();//Thêm
        splist.add(new SanPham("Dolce & Gabbana Perfume", "babbana", "100 ml Eau De Toilette Spray ", 199655302));
        splist.add(new SanPham("Montblanc Legend Cologne", "montblanc", "100 ml Eau De Toilette Spray (Tester)", 92230007));
        splist.add(new SanPham("Montblanc Explorer Cologne", "explorer", "100 ml Eau De Parfum Spray ", 130807269));
        splist.add(new SanPham("Montblanc Legend Spirit Cologne", "legend", "100 ml Eau De Toilette Spray ", 103970913));
        splist.add(new SanPham("Individuelle Cologne", "indi", "75 ml Eau De Toilette Spray ", 65393651));
        splist.add(new SanPham("The One Perfume", "theone", "50 ml Eau De Parfum Spray ", 112357275));
        splist.add(new SanPham("Dolce Perfume", "dolce", "75 ml Eau De Parfum Spray ", 149756453));
        adapter1 = new SPAdapter(splist);
        recyclerViewPopularList1.setAdapter(adapter1);//Hiển thị
    }

    // Calvin Klein
    private void recyclerViewPopular2() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList2 = findViewById(R.id.recyclerView3);
        recyclerViewPopularList2.setLayoutManager(linearLayoutManager);

        ArrayList<SanPham> splist = new ArrayList<>();
        splist.add(new SanPham("Eternity Cologne", "calvin1", "100 ml Eau De Toilette Spray ", 93907279));
        splist.add(new SanPham("Euphoria by Calvin Klein for Women", "calvin2", "100 ml Eau De Parfum Spray", 105648186));
        splist.add(new SanPham("Eternity Aqua Cologne", "calvin3", "100 ml Eau De Toilette Spray ", 63716378));
        splist.add(new SanPham("Ck Be Cologne", "calvin4", "195 ml Eau De Toilette Spray (Unisex Tester)", 55330017));
        splist.add(new SanPham("Euphoria Intense Cologne", "calvin5", "100 ml Eau De Toilette Spray (Tester)", 98939096));

        adapter2 = new SPAdapter(splist);
        recyclerViewPopularList2.setAdapter(adapter2);
    }

    // MontBlanc
    private void recyclerViewPopular3() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList3 = findViewById(R.id.recyclerView4);
        recyclerViewPopularList3.setLayoutManager(linearLayoutManager);

        ArrayList<SanPham> splist = new ArrayList<>();
        splist.add(new SanPham("Starwalker Cologne", "mont1", "75 ml Eau De Toilette Spray", 68748196));
        splist.add(new SanPham("Montblanc Legend Night Cologne", "mont2", "100 ml Eau De Parfum Spray", 134161814));
        splist.add(new SanPham("Individuelle Perfume", "mont3", "75 ml Eau De Toilette Spray", 65393651));
        splist.add(new SanPham("Individuel Tonic Cologne for men", "mont4", "75 ml Eau De Toilette Spray", 105648186));
        splist.add(new SanPham("Presence Cologne", "mont5", " 75 ml Eau De Toilette Spray ", 57007289));


        adapter3 = new SPAdapter(splist);
        recyclerViewPopularList3.setAdapter(adapter3);
    }
    // Christian Dior
    private void recyclerViewPopular4() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList4 = findViewById(R.id.recyclerView5);
        recyclerViewPopularList4.setLayoutManager(linearLayoutManager);

        ArrayList<SanPham> splist = new ArrayList<>();
        splist.add(new SanPham("Jadore Perfume", "dior1", " 30 ml Eau De Parfum Spray \n" + "Nhóm nước hoa: Hương hoa cỏ trái cây\n" +
                "\n" +
                "Giới tính: Nữ\n" +
                "\n" +
                "Độ tuổi khuyên dùng: Trên 25\n" +
                "\n" +
                "Năm ra mắt: 1999\n" +
                "\n" +
                "Nồng độ: EDP\n" +
                "\n" +
                "Nhà pha chế: Calice Becker\n" +
                "\n" +
                "Độ lưu hương: Lâu - 7 giờ đến 12 giờ\n" +
                "\n" +
                "Độ toả hương: Gần - Toả hương trong vòng một cánh tay\n" +
                "\n" +
                "Thời điểm khuyên dùng: Ngày, Đêm, Xuân\n" +
                "\n" +
                "Phong cách: Quý phải , Sang trọng , Nữ tính\n" +
                "\n" +
                "Hương Đầu: Hoa mộc lan, Dưa gang, Quả đào, Quả lê, Cam Bergamot, Quả quýt hồng\n" +
                "\n" +
                "Hương giữa: Hoa huệ trắng, Quả mận, Hoa tím, Hoa phong lan, Hoa lan Nam Phi, Hoa nhài, Hoa linh lan thung lũng, Hoa hồng\n" +
                "\n" +
                "Hương cuối: Xạ hương, Hương Va ni, Gỗ tuyết tùng, Quả mâm xôi đen \n" + ".Tổng quan: J`adore là một loại nước hoa hiện đại, quyến rũ và ngày càng trở nên phổ biến trên toàn thế giới, với lý do đó, chai nước hoa này đã được phát triển thành nhiều phiên bản với các nồng độ khác nhau. J`adore là sản phẩm nước hoa sang trọng, cùng với thiết kế màu vàng ròng rực rỡ phản chiếu lên da tựa như ánh mặt trời. J`adore được thiết kế bởi Calice Becker. Sản phẩm này được ra mắt vào năm 1999. \n"+ "J`adore là một loại nước hoa hiện đại, quyến rũ và ngày càng trở nên phổ biến trên toàn thế giới, với lý do đó, chai nước hoa này đã được phát triển thành nhiều phiên bản với các nồng độ khác nhau. J`adore là sản phẩm nước hoa sang trọng, cùng với thiết kế màu vàng ròng rực rỡ phản chiếu lên da tựa như ánh mặt trời. J`adore được thiết kế bởi Calice Becker. Sản phẩm này được ra mắt vào năm 1999.\n" +
                "\n  J'adore mở đầu với một mùi hương hoa cỏ kết hợp giữa hoa mộc lan, hoa nhài với mùi trái lê khi chín mọng, tạo ra một cảm giác giòn tan và hoàn toàn tươi mới. Mùi trái lê trong J'adore mang đến một cảm nhận tươi mát, ngọt ngào và hơi chua giống như khi cắn vào quả lê thật sự. Sau đó, để tạo ra sự nữ tính, nhưng không kém phần tinh nghịch pha một chút cổ điển, hỗn hợp mùi hương hoa huệ và hoa lài được đưa vào. Các nốt hương khác không quá mạnh, nhưng vẫn không bị lu mờ. J'adore lưu hương lâu và là một sản phẩm nước hoa theo phong cách vừa hiện đại vừa cổ điển. <br/>Hãy khám phá J’adore, một sản sản phẩm nước hoa mang tính chất biểu tượng nhằm tôn vinh sự nữ tính và sang trọng của phái nữ. Với thiết kế dành cho những người phụ nữ đầy tự tin, gợi cảm và luôn tự hào về sự nữ tính của riêng mình, J’adore của thương hiệu Dior đã trở thành một sản phẩm nước hoa luôn được phái nữ khao khát và trân trọng.", 9000000));
        splist.add(new SanPham("Hypnotic Poison Perfume", "dior2", "Nhóm nước hoa: Hương va-ni phương đông\n" +
                "\n" +
                "Giới tính: Nữ\n" +
                "\n" +
                "Độ tuổi khuyên dùng: Trên 25\n" +
                "\n" +
                "Năm ra mắt: 1998\n" +
                "\n" +
                "Nồng độ: EDT\n" +
                "\n" +
                "Nhà pha chế: Annick Menardo\n" +
                "\n" +
                "Độ lưu hương: Rất lâu - Trên 12 giờ\n" +
                "\n" +
                "Độ toả hương: Xa - Toả hương trong vòng bán kính 2 mét\n" +
                "\n" +
                "Thời điểm khuyên dùng: Ngày, Đêm, Đông\n" +
                "\n" +
                "Phong cách: Gợi cảm , Nữ tính , Quyến rũ\n" +
                "\n" +
                "Hương Đầu: Quả mơ, Quả mận, Quả dừa\n" +
                "\n" +
                "Hương giữa: Hoa huệ trắng, Hoa nhài, Hoa linh lan thung lũng, Hoa hồng, Gỗ cẩm lai Brazil, Thì là Ba Tư\n" +
                "\n" +
                "Hương cuối: Gỗ đàn hương, Hạnh nhân, Hương Va ni, Xạ hương.\n" + "Tổng quan: Hypnotic Poison bởi Christian Dior là một hương thơm Vanilla Phương Đông dành cho phái nữ. Hypnotic Poison đã được ra mắt vào năm 1998. Chế tác cho loại nước hoa này là Annick Menardo. \u200BĐược nhấn mạnh bởi hoa nhài, lớp hương đầu ngọt ngào dần lắng xuống bởi xạ hương và vani thanh lịch. Những lớp xạ hương mộc mạc, với sự trong trắng và cái chạm quyến rũ đó là sự tương phản đẹp mắt cùng với sự cay đắng của hạnh nhân, mang lại một sự kiềm chế cho những người sành ăn." , 8000000));
        splist.add(new SanPham("Miss Dior (miss Dior Cherie) Perfume", "dior3", " Nhóm nước hoa: Hương trái cây SÍP\n" +
                "\n" +
                "Giới tính: Nữ\n" +
                "\n" +
                "Độ tuổi khuyên dùng: Trên 25\n" +
                "\n" +
                "Năm ra mắt: 2011\n" +
                "\n" +
                "Nồng độ: EDP\n" +
                "\n" +
                "Nhà pha chế: Francois Demachy\n" +
                "\n" +
                "Độ lưu hương: Lâu - 7 giờ đến 12 giờ\n" +
                "\n" +
                "Độ toả hương: Gần - Toả hương trong vòng một cánh tay\n" +
                "\n" +
                "Thời điểm khuyên dùng: Ngày, Đêm, Xuân\n" +
                "\n" +
                "Phong cách: Trẻ trung , Ngọt ngào , Quyến rũ\n" +
                "\n" +
                "Hương Đầu: Quả quýt hồng, Dâu dại, Quả dâu tây\n" +
                "\n" +
                "Hương giữa: Hoa nhài, Hoa hồng\n" +
                "\n" +
                "Hương cuối: Cỏ hương bài, Gỗ đàn hương, Cây hoắc hương, Rêu cây sồi, Hổ phách" + "Tổng quan: Đây là một phiên bản mới tinh tế hơn và quyến rũ hơn các phiên bản từ năm 2005. Phiên bản mới này được tạo bởi Francois Demachy, người đã kết hợp các tinh chất để đóng góp nên sự hình thành của Dior's Cherie. Miss Dior Cherie Eau de Parfum đã được cho ra mắt vào năm 2011. MISS DIOR CHERIE Eau de Parfum trẻ trung và lãng mạn giống như một người phụ nữ sở hữu khẩu vị và phong cách tốt, cô ấy có cốt cách của một người phụ nữ thông minh, nhưng tuổi trẻ vẫn luôn là tuổi trẻ, và cô gái trẻ này trông xinh đẹp với một túi bỏng ngô trong tay.",  234418766));
        splist.add(new SanPham("Pure Poison Perfume", "dior4", "Nhóm nước hoa: Hương hoa cỏ\n" +
                "\n" +
                "Giới tính: Nữ\n" +
                "\n" +
                "Độ tuổi khuyên dùng: Trên 25\n" +
                "\n" +
                "Năm ra mắt: 2004\n" +
                "\n" +
                "Nồng độ: EDP\n" +
                "\n" +
                "Nhà pha chế: Olivier Polge\n" +
                "\n" +
                "Độ lưu hương: Lâu - 7 giờ đến 12 giờ\n" +
                "\n" +
                "Độ toả hương: Xa - Toả hương trong vòng bán kính 2 mét\n" +
                "\n" +
                "Thời điểm khuyên dùng: Ngày, Đêm, Xuân, Thu, Đông\n" +
                "\n" +
                "Phong cách: Gợi cảm , Quyến rũ , Cá tính\n" +
                "\n" +
                "Hương Đầu: Quả cam, Quả quýt hồng Sicili, Cam Bergamot, Hoa nhài\n" +
                "\n" +
                "Hương giữa: Hoa cam, Hoa sơn chi\n" +
                "\n" +
                "Hương cuối: Gỗ đàn hương, Gỗ tuyết tùng, Hổ phách trắng"+"Tổng quan: Pure Poison đã được tạo ra bởi ba chuyên gia, ba linh hồn vì vậy sản phẩm sưu tập này khiến người dùng thích thú với thành phần phức tạp và hài hòa đáng kinh ngạc. Pure Poison đã được sản xuất vào năm 2004, bởi ba chuyên gia sáng tạo là Carlos Benaim, Dominique Ropion và Olivier Polge với mùi hương quyến rũ thích hợp cho những dịp lãng mạn. Sự ấm áp tổng thể của mùi hương làm nó đặc biệt rất thích hợp với mùa đông và mùa thu.", 179707743));
        splist.add(new SanPham("Dior Addict Perfume", "dior5", "100 ml Eau De Parfum Spray\n"+"\n" +" Nhóm nước hoa: Hương hoa cỏ phương đông\n" +
                "\n" +
                "Giới tính: Nữ\n" +
                "\n" +
                "Độ tuổi khuyên dùng: Trên 25\n" +
                "\n" +
                "Năm ra mắt: 2012\n" +
                "\n" +
                "Nồng độ: EDP\n" +
                "\n" +
                "Nhà pha chế: Francois Demachy\n" +
                "\n" +
                "Độ lưu hương: Rất lâu - Trên 12 giờ\n" +
                "\n" +
                "Độ toả hương: Xa - Toả hương trong vòng bán kính 2 mét\n" +
                "\n" +
                "Thời điểm khuyên dùng: Ngày, Đêm, Thu, Đông\n" +
                "\n" +
                "Phong cách: Tính tế , Sang trọng , Quyến rũ\n" +
                "\n" +
                "Hương Đầu: Hoa bản xe, Quả quýt hồng, Hoa cam\n" +
                "\n" +
                "Hương giữa: Hoa quỳnh, Hoa hồng Bulgary\n" +
                "\n" +
                "Hương cuối: Hương Va ni, Gỗ đàn hương, Đậu Tonka\n" +
                "\n" + "Tổng quan: Dior Addict Eau de Parfum của thương hiệu Christian Dior là nước hoa hương hoa cỏ phương Đông dành cho phụ nữ và được ra mắt vào năm 2012. Chuyên gia Francois Demachy đã chế tạo ra loại nước hoa này. Dior Addict Eau de Parfum 2012 có thành phần nước hoa phương Đông và hiện đại, sinh động và dễ thương với màu xanh đậm xâu thẳm và sức mạnh gợi cảm của hoa xương rồng đêm, đây là nước hoa có hương thơm quyến rũ và cực kỳ thu hút.Dior Addict Eau de Parfum 2012 có thành phần nước hoa phương Đông và hiện đại, sinh động và dễ thương với màu xanh đậm xâu thẳm và sức mạnh gợi cảm của hoa xương rồng đêm, đây là nước hoa có hương thơm quyến rũ và cực kỳ thu hút. Hương thơm mở đầu tươi mát và hấp dẫn từ lá quýt, hoa cam và những bông vải. Lớp hương giữa nồng nhiệt và sôi động đã tiết lộ một kho tàng quý báu chính là hoa xương rồng đêm tươi mới và quyến rũ. Một bông hoa nhiệt đới mọc ở Jamaica và chỉ nở một lần duy nhất trong năm để tỏa ra hương thơm đặc trưng và mạnh mẽ và có mùi hương giống như vani. Sau cùng hãy tượng tượng như bạn đang ở trong một đêm hè ấm áp, lớp hương cuối mượt mà và gợi cảm đọng lại trên da với mùi hương dịu nhẹ.", 8500000));

        adapter4 = new SPAdapter(splist);
        recyclerViewPopularList4.setAdapter(adapter4);
    }

    //    Jimmy Choo
    private void recyclerViewPopular5() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList5 = findViewById(R.id.recyclerView6);
        recyclerViewPopularList5.setLayoutManager(linearLayoutManager);

        ArrayList<SanPham> splist = new ArrayList<>();
        splist.add(new SanPham("Jimmy Choo Perfume", "choo1", "60 ml Eau De Parfum Spray\n"+"\n" +"Nhóm nước hoa: Hương trái cây SÍP\n" +
                "\n" +
                "Giới tính: Nữ\n" +
                "\n" +
                "Độ tuổi khuyên dùng: Trên 25\n" +
                "\n" +
                "Năm ra mắt: 2011\n" +
                "\n" +
                "Nồng độ: EDP\n" +
                "\n" +
                "Nhà pha chế: Olivier Polge\n" +
                "\n" +
                "Độ lưu hương: Lâu - 7 giờ đến 12 giờ\n" +
                "\n" +
                "Độ toả hương: Gần - Toả hương trong vòng một cánh tay\n" +
                "\n" +
                "Thời điểm khuyên dùng: Ngày, Đêm, Xuân, Thu, Đông\n" +
                "\n" +
                "Phong cách: Gợi cảm , Quyến rũ , Cá tính\n" +
                "\n" +
                "Hương Đầu: Quả quýt hồng, Quả lê, Hương lục\n" +
                "\n" +
                "Hương giữa: Hoa phong lan\n" +
                "\n" +
                "Hương cuối: Kẹo bơ cứng, Cây hoắc hương \n"+
                "\n" +"Tổng quan: Thương hiệu phổ biến nhất của giày sang trọng và các phụ kiện thời trang, Jimmy Choo đã cho ra mắt chai nước hoa đầu tiên với tên gọi đơn giản là Jimmy Choo. Nước hoa Jimmy Choo được trình bày như là món phụ kiện tuyệt đỉnh để hoàn chỉnh phong cách của người thiết kế. Tamara Mellon, người đồng sáng lập của công ty, thú nhận rằng cô thích sử dụng nước hoa và luôn muốn được sở hữu một chai nước hoa mang mùi hương như Jimmy Choo. Cô đã đạt được mong muốn của mình với một hương thơm nữ tính mạnh mẽ này. Jimmy Choo ra mắt vào tháng Hai năm 2011. Được phát triển với sự hợp tác với Inter Parfums và nhà chế tạo nước hoa nổi tiếng từ IFF, Olivier Polge.", 105648186));
        splist.add(new SanPham("Jimmy Choo I Want Choo Perfume", "choo2", "Jimmy Choo\n" +
                "Xuất xứ\n" +
                "Anh, Pháp\n" +
                "Năm phát hành\n" +
                "2020\n" +
                "Nhóm hương\n" +
                "Hương vani, Hoa nhài, Quả đào\n" +
                "Phong cách\n" +
                "Quyến rũ, Nữ tính, Ngọt ngào\n" +
                "Hương đầu: Nước Cam, quả Đào\n" +
                "Hương giữa: Hoa Huệ Đỏ, Hoa Nhài\n" +
                "Hương cuối: Vanilla\n" +
                "\n" +
                "I Want Choo, hương thơm mới của nhà thiết kế thời trang Jimmy Choo ra mắt vào năm 2020, được công bố là hương hoa phương Đông lấp lánh thấm đẫm hương quả Đào căng mọng, giòn tan và quấn quanh bởi lớp hương Vani mượt mà, hương thơm gợi lên sự ngon ngọt, trong lành, khiến tiếng lòng của bạn buộc phải thốt lên “I want Choo” . Hương thơm thay đổi từ vị Đào và Quýt thanh mát, Vani mềm mại, mượt mà sang sự quyến rũ của những cánh hoa huệ và nét đẹp tinh tế ẩn nấp trong hoa nhài. I want Choo chính là một phụ kiện hoàn hảo cho một người phụ nữ hiện đại và gợi cảm.", 234418766));
        splist.add(new SanPham("Illicit Perfume", "choo3", "Thương hiệu\n" +
                "Jimmy Choo\n" +
                "Xuất xứ\n" +
                "Anh, Pháp\n" +
                "Năm phát hành\n" +
                "2015\n" +
                "Nhóm hương\n" +
                "Mật ong, Gừng, Hổ phách\n" +
                "Phong cách\n" +
                "Ngọt ngào, Quyến rũ, Gợi cảm\n" +
                "Hương đầu: Gừng, Cam đắng\n" +
                "Hương giữa: Hoa hồng, Hoa nhài, Hoa cam\n" +
                "Hương cuối: Hổ phách, Mật ong, Gỗ đàn hương, Caramel, Gỗ Cashmere, Vanilla\n" +
                "\n" +
                "Đem tới sự hiện đại cùng với vẻ ngoài dịu dàng, quyến rũ, Jimmy Choo Illicit tạo ra một làn sóng cuốn hút các cô nàng yêu thích nước hoa phải mong muốn có được trong “chiếc túi” của mình.\n" +
                "\n" +
                "Dường như thôi miên các ánh mắt của phụ nữ, hương thơm của Illicit có sức lan tỏa vô cùng mạnh liệt thông qua phong thái sang trọng và đầy trẻ trung ngay khi những nốt hương Gừng, Cam đắng vang lên. Đến khi sự quyến rũ của Hoa hồng, Hoa nhài và Hoa Cam phảng phất, tầng hương giữa như phép màu biến mọi cô gái trở nên hấp dẫn, thu hút hơn trong mắt mọi chàng trai xung quanh họ.\n" +
                "\n" +
                "Mãi cho đến khi sư ngọt ngào của Mật ong từ tốn tôn lên sự nữ tính bên trong, loạt hương Gỗ cùng các nốt hương được lưu giữ ở tầng hương cuối trỗi dậy mãnh liệt để lại hình bóng, dáng vẻ các nàng trên mỗi bước chân mà họ bước qua.\n" +
                "\n" +
                "Xem thêm", 105648186));
        splist.add(new SanPham("Jimmy Choo Man Blue Cologne", "choo4", "100 ml Eau De Toilette Spray (Tester)\n"+"Thương hiệu nước hoa: Jimmy Choo\n" +
                "Xuất xứ: Anh Quốc\n" +
                "Nhà sáng chế: Nathalie Lorson\n" +
                "Thời điểm ra mắt: 2018\n" +
                "Nồng độ nước hoa: EDT – Eau De Toilette\n" +
                "Nhóm hương chính: Woody Aromatic – Hương gỗ thơm\n" +
                "Độ tỏa hương: Trong vòng một cánh tay, gần\n" +
                "Thời gian lưu lại hương thơm: Trung bình từ 3 – 6 tiếng\n" +
                "Phong cách thể hiện: Hiện đại, nam tính, trẻ trung và thanh lịch\n" +
                "Lớp hương đầu: Tiêu đen, xô thơm, Lavender, Cam Bergamot\n" +
                "Lớp hương giữa: Cây bách diệp, da thuộc, long diên hương, dứa, táo\n" +
                "Lớp hương cuối: Vanilla, hoắc hương, đàn hương, cỏ hương bài\n" +
                "Thời gian sử dụng thích hợp: xuân – hạ – thu, ban ngày và cả đêm\n" +
                "Dung tích chai phổ biến: 30ml, 50ml, 100ml\n" + "Nước hoa Jimmy Choo Man Blue 100ml được xem như một chương nối tiếp về những dòng nước hoa cho nam nổi tiếng của thương hiệu Jimmy Choo. Mùi hương của chai nước hoa này phô bày sự hiện đại của cuộc sống vô cùng sinh động diễn ra mỗi ngày. Hương thơm ấm áp hài hòa hòa từ Jimmy Choo Man Blue đã phá bỏ ranh giới của những bộ vest lịch lãm với chất sáng tạo tự do của nghệ thuật đường phố. Jimmy Choo Man Blue 100ml mang đến nốt hương cực kì cùng tinh tế và lôi cuốn, đến từ nhóm hương gỗ thơm. Nước hoa này thích hợp mang đến sự cảm nhận về khí chất trẻ trung, hiện đại, không kém phần sang trọng, thanh lịch.\n" +
                "\n", 80868484));
        splist.add(new SanPham("Jimmy Choo Man Intense Cologne", "choo5", "50 ml Eau De Toilette Spray\n"+"Nhóm nước hoa:\n" +
                "\n" +
                "Giới tính: Nam\n" +
                "\n" +
                "Độ tuổi khuyên dùng: Trên 25\n" +
                "\n" +
                "Năm ra mắt: 2016\n" +
                "\n" +
                "Nồng độ:\n" +
                "\n" +
                "Nhà pha chế:\n" +
                "\n" +
                "Độ lưu hương: Lâu - 7 giờ đến 12 giờ\n" +
                "\n" +
                "Độ toả hương: Gần - Toả hương trong vòng một cánh tay\n" +
                "\n" +
                "Thời điểm khuyên dùng: Ngày, Đêm, Xuân, Thu\n" +
                "\n" +
                "Hương Đầu: Hoa Oải Hương, Dưa gang, Quả quýt hồng\n" +
                "\n" +
                "Hương giữa: Ngải, Tiêu đen, Hoa phong lữ\n" +
                "\n" +
                "Hương cuối: Đậu Tonka, Cây hoắc hương, Hương Labdanum" + "Nước hoa nam Jimmy Choo Man Intense phù hợp với người trên 25 tuổi.Đây là dòng nước hoa Jimmy Choo này có độ lưu hương lâu - 7 giờ đến 12 giờ. và độ tỏa hương thuộc dạng gần - toả hương trong vòng một cánh tay. Perfumista.vn khuyến cáo Jimmy Choo Man Intense phù hợp để sử dụng trong cả ngày lẫn đêm vào mùa xuân, thu.\n" +
                "\n" +
                "Jimmy Choo Man Intense được cho ra mắt vào năm 2016. Bên cạnh đó, Dưa gang và Đậu Tonka là hai hương bạn có thể dễ dàng cảm nhận được nhất khi sử dụng nước hoa này.", 85361178));

        adapter5 = new SPAdapter(splist);
        recyclerViewPopularList5.setAdapter(adapter5);
    }

}