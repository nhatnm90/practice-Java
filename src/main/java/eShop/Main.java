package eShop;

import eShop.Model.*;

import java.util.ArrayList;
import java.util.Collections;

import static bank.Account.dash;
import static java.util.Comparator.comparing;
import static utils.StringFormat.formatCurrency;
import static utils.StringFormat.printSeparatedLine;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


public class Main {


    public static void main(String[] args) {
        Database database = InitData.run();
        List<Category> categories = database.categories;
        List<Product> products = database.products;
        List<Order> orders = database.orders;
        List<OrderDetail> orderDetails = database.orderDetails;

        System.out.println("eShop");


        // C1:

        Collections.sort(products, comparing(Product::getUnitPrice).reversed());
        // 1 cách khác viết gọn hơn
        // ListSort.sort(comparing(ClassSort::PropertySort));
        // ListSort: products
        // ClassSort: Product
        // PropertySort: getUnitPrice
        // products.sort(comparing(Product::getUnitPrice).reversed());


        // C2:
        for (Category category : categories) {
            category.setActive(true);
        }

        // C3:
        Collections.sort(categories, comparing(Category::countCharacter));
        // Cách viết này có thể truyền parameter vào trong function nếu mình thực sự cần dùng đến parameter
        // Cách này kiểu viết lambda hay còn gọi là arrow function
        // Body của lambda:
        // Ví du:
        // object -> object.functionOfClass(parameters)
        // object: category
        // functionOfClass: countCharacter() -> the object ONLY call the function of the CLASS that this object was generated from
        // parameters: category.getCategoryName()
        // category -> category.countCharacter(category.getCategoryName())
        // Collections.sort(categories, comparing(category -> category.countCharacter(category.getCategoryName())));
        for (int i = 0; i < categories.size(); i++) {
            categories.get(i).setOrder(i);
        }


        // C4:
        List<Category> parentList = new ArrayList<>();
        for (Category category : categories) {
            if (category.getParentCategoryId() == null) {
                parentList.add(category);
            }
        }
        for (Category parentCategory : parentList) {
            boolean isParent = false;
            for (Category category : categories) {
//                if (parentCategory.getCategoryId() == category.getParentCategoryId()){
//                    isParent = true;
//                    break;
//                }
                isParent = categories.stream().anyMatch(
                        x -> parentCategory.getCategoryId() == x.getParentCategoryId()
                );
            }
            // Cách viết khác, gọn hơn, không bắt buộc phải theo nhưng nên tập để code gọn hơn và
            // thường đa số mọi người đều dùng nên mình cứ dùng từ từ cho quen à e
            //if (!isParent)
            if (isParent == false) {
                parentCategory.setActive(false);
            }
//            System.out.println(parentCategory.isActive());
        }

        // C5:
        System.out.println("Câu 5");
        List<Category> childrenList = new ArrayList<>();
        for (Category category : categories) {
            if (category.getParentCategoryId() != null) {
                childrenList.add(category);
            }
        }
        for (Category parentCategory : parentList) {
            showCategoryInfo(parentCategory);
            int numOfChildren = 0;
            for (Category childrenCategory : childrenList) {
                if (childrenCategory.getParentCategoryId() == parentCategory.getCategoryId()) {
                    numOfChildren++;
                }
            }
            if (numOfChildren > 0) {
                System.out.println("Số danh mục con: " + numOfChildren);
            } else {
                System.out.println("Không tồn tại danh mục con");
            }
            dash();
            for (Category category : categories) {
                if (parentCategory.getCategoryId() == category.getParentCategoryId()) {
                    showCategoryInfo(category);
                    System.out.println("Không tồn tại danh mục con");
                    dash();
                }
            }
        }

        //C6:
        System.out.println("Câu 6");
        Collections.sort(products, comparing(Product::countCharacter).reversed());
        for (Category category : categories) {
            if (products.get(0).getCategoryId() == category.getCategoryId()) {
                System.out.println(products.get(0).getProductName() + " thuộc " +
                        category.findCategoryById(categories, category.getParentCategoryId()) + " > " +
                        category.findCategoryById(categories, category.getCategoryId()));
            }
        }

        // Nếu mình đã tìm đc product có tên dài nhất thì sau đó mình lấy luôn category của product đó xài luôn
        // mình không cần loop qua cái list category làm gì hết e ha
        Product productWithLongestName = products.get(0);
        Category cate = getCategoryById(categories, productWithLongestName.getCategoryId());
        Category parentCate = getCategoryById(categories, cate.getParentCategoryId());
        System.out.println(productWithLongestName.getProductName() + " thuộc " +
                parentCate.getCategoryName() + " > " +
                cate.getCategoryName());

        //C7:
        for (Product product : products) {
            product.setInitOnHand();
        }

        // C8:
        for (Product product : products) {
            product.updateProductNameToLowerCase();
        }

        // C9:
        products.sort(comparing(Product::getUnitPrice).reversed());
        products.get(0).updateProductStatus();

        // yêu cầu của câu 9 là chỉ cập nhật trạng thái isActive của sản phẩm thấp nhất trong MỖI danh mục sản phẩm (category)
        // theo cách trình bày trên là mình đang chỉ cập nhật giá thấp nhất của hệ thống chứ không phải theo mỗi danh mục sản phẩm à e

        // C10:
        System.out.println("Câu 10: ");
        products.sort(comparing(Product::getUnitPrice).reversed());
        for (Category category10 : categories) {
            if (category10.getParentCategoryId() != null) {
                dash();
                System.out.println("Category: " + category10.getCategoryName());
                int orderNumber = 0;
                for (Product product : products) {
                    if (product.getCategoryId() == category10.getCategoryId()) {
                        product.setOrder(orderNumber);
                        orderNumber++;
                        product.showInfo();
                    }
                }
            }
        }

        // ở câu này đáp án cuối cùng sẽ đúng à e, nhưng có vẻ cách làm này nó bị cồng kềnh quá á,
        // vì lúc nào mình cũng phải loop qua tất cả sản phẩm cũng mỗi danh mục để tìm sản phẩm đó hết
        // thay vì vậy ở mỗi danh mục sản phẩm, mình chỉ nên lấy sản phẩm của danh mục đó ra thôi hen

        System.out.println("Câu 10a: ");
        // mình chỉ lấy những category nào chứa sản phẩm thôi, category cha thì khỏi cần loop qua hen e
        // lúc này mình sẽ ko cần tốn 1 cái if để check cái category đó có phải là cate con hay ko
        for (Category category10a : childrenList) {
            dash();
            System.out.println("Category: " + category10a.getCategoryName());
            // mình chỉ lấy những product thuộc category đang loop qua thôi, lúc này sẽ hạn chế việc lúc nào cũng chạy qua hết danh sách product
            List<Product> sortedProductsByCate = getListSortByPriceProductByCategory(products, category10a.getCategoryId());
            // thay vì dùng for kiểu kia thì mình xài for thuần sẽ tận dụng đc biến index hen e
            for (int i = 0; i < sortedProductsByCate.size(); i++) {
                sortedProductsByCate.get(i).setOrder(i);
                sortedProductsByCate.get(i).showInfo();
            }
        }

        // C11:
        System.out.println("Câu 11");
        for (Category categoryChild : childrenList) {
            List<Product> productsInCategory = new ArrayList<>();
            for (Product product : products) {
                if (product.getCategoryId() == categoryChild.getCategoryId()) {
                    productsInCategory.add(product);
                }
            }
            productsInCategory.sort(comparing(Product::getUnitPrice));
            if (productsInCategory.size() > 0) {
                System.out.println("Danh mục con: " + categoryChild.getCategoryName());
                System.out.println("Sản phẩm giá cao nhất: " + productsInCategory.get(0).getProductName());
                System.out.println("Giá: " + formatCurrency(productsInCategory.get(0).getUnitPrice(), "vn", "VN"));
            } else {
                System.out.println("Danh mục " + categoryChild.getCategoryName() + " không có sản phẩm ");
            }
            printSeparatedLine(50, "=");
        }

        // câu này mình sửa lại tương tự câu trên hen e, theo cách là cứ tìm danh mục sản phẩm mà chỉ chứa sản phẩm
        // tìm ta sản phẩm của danh mục đó
        // sort sản phẩm theo giá
        // lấy sản phẩm giá cao nhất và in ra thôi hen

        // C12:
        System.out.println("Câu 12");
        for (Category category12 : childrenList) {
            int number = 0;
            // chỗ này là lúc nào mình cũng phải loop qua hết cái danh sách nè e, hơi bị hao performance ở đây nè
            for (Product product : products) {
                if (category12.getCategoryId() == product.getCategoryId()) {
                    number++;
                }
            }
            System.out.println("Danh mục sản phẩm: " + category12.getCategoryName());
            System.out.println("Số lượng sản phẩm: " + number);
        }

        System.out.println("Câu 12a");
        for (Category category12a : childrenList) {
            List<Product> listProductByCate = getListProductByCategory(products, category12a.getCategoryId());
            System.out.println("Danh mục sản phẩm: " + category12a.getCategoryName());
            System.out.println("Số lượng sản phẩm: " + listProductByCate.size());
        }
    }

    private static Category getCategoryById(List<Category> categories, UUID categoryId) {
        return categories.stream().filter(cate -> cate.getCategoryId() == categoryId)
                .findAny().orElse(null);
    }

    private static List<Product> getListProductByCategory(List<Product> products, UUID categoryId) {
        return products.stream().filter(cate -> cate.getCategoryId() == categoryId)
                .collect(Collectors.toList());
    }

    private static List<Product> getListSortByPriceProductByCategory(List<Product> products, UUID categoryId) {
        List<Product> productsByCate = products.stream().filter(product -> product.getCategoryId().equals(categoryId))
                .collect(Collectors.toList());
        productsByCate.sort(comparing(Product::getUnitPrice).reversed());
        return productsByCate;
    }


    public static void showCategoryInfo(Category category) {
        if (category.getParentCategoryId() == null) {
            if (category.getCategoryName() == "Da" || category.getCategoryName() == "Mặt") {
                System.out.println("Danh mục chính: Chăm sóc " + category.getCategoryName().toLowerCase());
            } else {
                System.out.println("Danh mục chính: " + category.getCategoryName());
            }
        } else {
            System.out.println("Danh mục con: " + category.getCategoryName());
        }
        if (category.isActive()) {
            System.out.println("Trạng Thái: Kích hoạt");
        } else {
            System.out.println("Trạng Thái: Tạm ngưng");
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
 *   Câu 23: Trong chi tiết đơn hàng (OrderDetail) tính tổng giá tiền của từng chi tiết đơn hàng (OrderDetail.totalPrice) dựa vào giá và số lượng
 *   totalPrice = unitPrice * quantity
 *
 *   Câu 24: Trong danh sách đơn hàng (Order) hãy cập nhật danh sách chi tiết đơn hàng (Order.orderDetails) bằng cách tìm trong danh sách chi tiết đơn hàng
 *   những chi tiết đơn hàng tương ứng (OrderDetail.orderId).
 *
 *   Câu 25: Tính giá trị đơn hàng trong danh sách đơn hàng (Order.totalPrice)
 *   bằng cách tính tổng giá trị của từng chi tiết đơn hàng (OrderDetail) thuộc về đơn hàng đó
 *
 *   Câu 26: Dựa vào danh sách chi tiết đơn hàng (OrderDetail) hãy tìm số lượng sản phẩm đã bán được của mỗi mặt hàng và
 *   cập nhật lại vào số lượng đã bán trong sản phẩm (Product.soldItem)
 *   Tính tổng tất cả sản phẩm đã bán và không bị trả
 *
 *   Câu 27: In ra top 10 sản phẩm được bán nhiều nhất và sắp xếp theo thứ tự số lượng bán giảm dần (format tùy vào mình, miễn sao rõ ràng đủ thông tin là đc e)
 *
 *   Câu 28: Đánh dấu sản phẩm là yêu thích (Product.isFavorite) bằng cách dựa vào số lượng sản phẩm đã bán được,
 *   nếu sản phẩm đó bán trên 5 được tính là yêu thích (Product.soldItem > 5) -> yêu thích
 *
 *   Câu 29: Thêm 1 property/state mới cho sản phẩm để tính giá nhập của mỗi sản phẩm (Product.importUnitPrice)
 *   và tính giá trị của giá nhập bằng công thức sau:
 *       Điều kiện       |       Công thức tính
 *   ----------------------------------------------
 *       < 50 000        |           80%
 *       < 200 000       |           85%
 *       < 500 000       |           90 %
 *       < 1 000 000     |           95%
 *   Giá bán của sản phẩm < 50 000 -> giá nhập = 80% giá bán (unitPrice < 50000 -> importUnitPrice = 80% of unitPrice)
 *
 *   Câu 30: Tính lợi nhuận thu được từ mỗi sản phẩm bán ra theo cách lấy chênh lệch của giá nhập và giá bán nhân với số lượng đã bán
 *   Có thế thêm property/state mới hoặc chỉ cần tính toán và in ra màn hình là được
 *
 *   Câu 31: Thay đổi công thức tính sản phẩm yêu thích (Product.isFavorite) như sau:
 *   Sản phẩm được coi là yêu thích nếu thỏa 1 trong 2 điều kiện sau
 *   Số lượng bán đc > 8 hoặc doanh thu từ số sản phẩm đã bán > 200 000 đ
 *
 *   Câu 32:  In ra danh sách TOP 5 sản phẩm bán ế nhất, tiêu chí ế đc tính bằng số sản phẩm đc bán ít nhất (Product.soldItem)
 *
 * */