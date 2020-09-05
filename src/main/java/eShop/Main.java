package eShop;

import eShop.Model.*;

import java.util.ArrayList;
import java.util.Collections;
import static java.util.Comparator.comparing;

import java.util.List;

import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args){
        Database database = InitData.run();
        List<Category> categories = database.categories;
        List<Product> products = database.products;
        List<Order> orders = database.orders;
        List<OrderDetail> orderDetails = database.orderDetails;

        System.out.println("eShop");


        // C1:
        Collections.sort(products, comparing(Product::getUnitPrice).reversed());

        //C2:
        for (Category category : categories){
            category.setActive(true);
        }

        //C3:
        Collections.sort(categories, comparing(Category::countCharacter));
        for (int i = 0; i < categories.size(); i++){
            categories.get(i).setOrder(i);
        }


        //C4:
        List<Category> parentList = new ArrayList<>();
        for (Category category : categories){
            if (category.getParentCategoryId() == null){
                parentList.add(category);
            }

        }
        for (Category parentCategory : parentList){
            boolean isParent = false;
            for (Category category : categories ){
//                if (parentCategory.getCategoryId() == category.getParentCategoryId()){
//                    isParent = true;
//                    break;
//                }
                isParent = categories.stream().anyMatch(
                        x -> parentCategory.getCategoryId() == x.getParentCategoryId()
                );
            }
            if (isParent == false) {
                parentCategory.setActive(false);
            }
            System.out.println(parentCategory.isActive());
        }
    }

}










/*
*
*   Câu 1: sắp xếp sản phẩm theo giá tăng dần
*
*   Câu 2: viết phương thức cập nhật trang thái cho tất cả các danh mục sản phẩm isActive = TRUE
*
*   Câu 3: sắp xếp cách danh mục sản phẩm (Category) gán thứ tự (order) của mỗi danh mục theo thứ tự tăng dần theo độ dài của tên danh mục
*   Danh mục tên có độ dài tên càng nhiều thì thứ tự càng lớn
*
*   Câu 4: cập nhật trạng thái isActive = FALSE của danh mục sản phẩm cha mà ko có danh mục sản phẩm con nào
*
*   Câu 5: In ra màn hình danh sách danh mục sản phẩm theo format sau, quan hệ giữa các danh mục được tính bằng parentCategoryId
*   isActive = True ? "Kích hoạt" : "Tạm ngưng"
*   Ví du:
*   =================================================================
*   Danh mục chính: Chăm sóc da
*   Trang thái: Kích hoạt
*   Số danh mục con: xxx
*   -----------------------------------------------------------------
*   Danh mục con: Trang điểm
*   Trang thái: Kích hoạt
*   Số danh mục con: xxx
*   -----------------------------------------------------------------
*   Danh mục con: Chăm sóc mặt
*   Trang thái: Tạm ngưng
*   Số danh mục con: xxx
*   =================================================================
*   Danh mục chính: Dầu gội đầu
*   Trang thái: Kích hoạt
*   Không tồn tại danh mục con
*   =================================================================
*
*   Câu 6: In ra tên sản phẩm dài nhất trong tất cả các sản phẩm và tên danh mục cha và con của sản phẩm đó
*   Ví dụ:
*   [Tên sản phẩm] thuộc [Danh mục sản phẩm cha] > [Danh mục sản phẩm con]
*   "Kem dưỡng da mặt và da khắp cơ thể 1000 ml abc...xyz" thuộc Chăm sóc da > Kem dưỡng da
*
*   Câu 7: Viết phương thức để cập nhật số lượng onHand của tất cả sản phẩm ban đầu là 100
*
*   Câu 8: Viết phương thức để cập nhật tất cả tên sản phẩm thành chữ thường (lower case)
*
*   Câu 9: Viết phương thức để cập nhật trạng thái (isActive) của sản phẩm. Với mới danh mục sản phẩm, cập nhật isActive của sản phẩm thấp nhất thành FALSE
*
*   Câu 10: Đánh thứ tự của sản phẩm trong từng danh mục sản phẩm theo tiêu chí, giá càng cao order càng nhỏ
*   Lưu ý: chỉ đánh thứ tự trong từng danh mục con. Danh mục sản phẩm Trang điểm có 10 sản phẩm thì sản phẩm giá cao nhất order = 0,
*   ở các danh mục khác cũng tương tự, sản phẩm có giá càng cao nhất order = 0
*
*   Câu 11: Với mỗi danh mục sản phẩm con (danh mục chứa sản phẩm), in ra tên sản phẩm có giá cao nhất
*   Ví dụ:
*   =================================================================
*   Danh mục sản phẩm: Xịt khoáng
*   Sản phẩm giá cao nhất: xxx
*   Giá: xxx
*   =================================================================
*   Danh mục sản phẩm: Mặt nạ
*   Sản phẩm giá cao nhất: xxx
*   Giá: xxx
*   =================================================================
*   ...
*
*   Câu 12: Với mỗi danh mục sản phẩm con (danh mục chứa sản phẩm, và có parentCategoryId), in ra số sản phẩm tồn tại trong danh mục đó
*   Ví dụ:
*   =================================================================
*   Danh mục sản phẩm: Xịt khoáng
*   Số lượng sản phẩm: xxx
*   =================================================================
*   Danh mục sản phẩm: Mặt nạ
*   Số lượng sản phẩm: xxx
*   =================================================================
*   ...
*
*   Câu 13: Tìm và in ra số lượng sản phẩm của mỗi danh mục sản phẩm cha, danh mục sản phẩm mà có parentCategoryId = null
*   Ví dụ:
*   =================================================================
*   Danh mục sản phẩm: Xịt khoáng
*   Số lượng sản phẩm: xxx
*   =================================================================
*   Danh mục sản phẩm: Mặt nạ
*   Số lượng sản phẩm: xxx
*   =================================================================
*   ...
*
*   Câu 14: Vẽ sơ đồ danh mục sản phẩm (Danh mục cha > Danh mục con) và sắp xếp theo thứ tự Alphabet,  nếu không thể vẽ ra cây thư mục như trên có thể trình bày theo cách khác
*   đơn giản hơn, miễn sao người xem hiểu là đc
*
*   |____ Da
*   |     |____ Dưỡng thể
*   |
*   |____ Mặt
*   |     |____ Tẩy trang
*   |     |____ Xịt khoáng
*   |     |____ Kem chống nắng
*   |
*   |____ Trang điểm
*   |   |____ Tẩy trang
*   |   |____ Son
*   |
*   |____ Dầu gội đầu
*
*   Câu 15: Với sơ đồ trên, hãy thêm vào danh sách sản phẩm, với mỗi sản phẩm, hiển thị tên và giá bán
*
*   |____ Da
*   |     |____ Dưỡng thể
*   |           |____ Tẩy tế bào chết - 171 000 đ
*   |
*   |____ Mặt
*   |     |____ Tẩy trang
*   |     |     |____ Laroche Posay - 269 000 đ
*   |     |     |____ Avene - 297 000 đ
*   |     |
*   |     |____ Xịt khoáng
*   |     |____ Kem chống nắng
*   |
*   |____ Trang điểm
*   |     |____ Tẩy trang
*   |     |____ Son
*   |
*   |____ Dầu gội đầu
*
*   Câu 16: Viết phương thức tính ra số lượng đơn hàng được giao bởi 1 shippingBrand truyền vào
*   Ví dụ: getNumberOfOrderByShippingBrand(ShippingBrand shippingBrand) { return 0; }
*
*   Câu 17: In ra tên ShippingBrand có số lượng đơn hàng đã được hoàn thành (Order.status = Received) nhiều nhất
*
*   Câu 18: In ra danh sách đơn hàng tranh toán bằng tiền mặt (Order.paymentMethod = Cash)
*
*   Câu 19: Do trang thái của mỗi đơn hàng lúc tạo ra luôn luôn là waitingForPayment (constructor của Order luôn set Order.status = waitingForPayment)
*   Nên sẽ không hợp lý nếu những đơn hàng được tạo ra với phương thức thanh toán điện tử (Momo, Grab, Credit Card...).
*   Hãy cập nhật lại trạng thái đơn hàng (Order.status) của những đơn hàng đó qua trạng thái confirmed
*
*   Câu 20: Những đơn hàng có trạng thái là đang giao hàng (Order.status = shipping) nhưng ngày tạo quá 15 ngày
*   so với ngày hiện tại thì được coi là đơn hàng giao quá chậm và bị hủy.
*   Hãy cập nhật lại trạng thái là hủy (Order.status = canceled) cho những đơn hàng đó
*
*   Câu 21: Tìm đơn vị vận chuyển mà có số lượng đơn hàng bị hủy nhiều nhất
*
*   Câu 22: Từ danh sách sản phẩm (Product) và danh sách chi tiết đơn hàng (OrderDetail),
*   hãy cập nhật giá (Product.unitPrice) của sản phẩm tương ứng vào chi tiết đơn hàng tương ứng (OrderDetail.unitPrice)
*
*   Câu 23: Trong chi tiết đơn hàng (OrderDetail) tính tổng giá tiền của từng record chi tiết đơn hàng (OrderDetail.totalPrice) dựa vào giá và số lượng
*   totalPrice = unitPrice * quantity
*
*   Câu 24: Trong danh sách đơn hàng (Order) hãy cập nhật danh sách chi tiết đơn hàng (Order.orderDetails) bằng cách tìm trong danh sách chi tiết đơn hàng
*   những chi tiết đơn hàng tương ứng (OrderDetail.orderId)
*
*   Câu 25: Tính giá trị đơn hàng trong danh sách đơn hàng (Order.totalPrice)
*   bằng cách tính tổng giá trị của từng chi tiết đơn hàng (OrderDetail) thuộc về đơn hàng đó
*
* */
