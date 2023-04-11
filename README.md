# Spring-Security
Spring Security Basic 

    Câu hỏi : 
1.Trình bày khái niệm liên quan đến các đối tượng sau:
UserNamePasswordAuthenticationToken
AuthenticationManager
AuthenticationProvider
PasswordEncoder
UserDetailsService
UserDetails


+) UserNamePasswordAuthenticationToken : 
-UserNamePasswordAuthenticationToken là một lớp trong Spring Security, được sử dụng để tạo đối tượng Authentication từ thông tin đăng nhập của người dùng.
Nó kế thừa từ lớp AbstractAuthenticationToken.
-UserNamePasswordAuthenticationToken chứa thông tin tên đăng nhập (username) và mật khẩu (password) của người dùng.
Khi người dùng đăng nhập, Spring Security sẽ sử dụng đối tượng này để xác thực và xác định vai trò của người dùng.
-UserNamePasswordAuthenticationToken có thể được tạo bằng cách sử dụng constructor với hai tham số là username và password, 
hoặc sử dụng constructor với ba tham số để đặt thêm danh sách các quyền (authorities) của người dùng

+) AuthenticationManager : AuthenticationManager là một interface trong Spring Security, cung cấp phương thức để xác thực thông tin đăng nhập của người dùng
và tạo đối tượng Authentication tương ứng.Khi một yêu cầu đến ứng dụng được bảo vệ bằng Spring Security, 
một đối tượng Authentication sẽ được tạo ra từ thông tin đăng nhập của người dùng (ví dụ như UserNamePasswordAuthenticationToken). 
Sau đó, đối tượng Authentication này được truyền đến AuthenticationManager để xác thực thông tin đăng nhập của người dùng.

+) AuthenticationProvider : AuthenticationProvider là một interface trong Spring Security, cung cấp phương thức để xác thực thông tin đăng nhập của người dùng.

+) PasswordEncoder : PasswordEncoder là một interface trong Spring Security, cung cấp phương thức để mã hóa mật khẩu người dùng và 
so sánh mật khẩu đã được mã hóa với mật khẩu gốc để xác thực người dùng. Mục đích của việc mã hóa mật khẩu là để bảo mật thông tin mật khẩu của người dùng
khi lưu trữ trong cơ sở dữ liệu, vì nếu thông tin mật khẩu của người dùng bị lộ ra ngoài, thì hacker có thể sử dụng nó để truy cập vào hệ thống.
Spring Security cung cấp nhiều lớp PasswordEncoder để sử dụng,
chẳng hạn như BCryptPasswordEncoder, NoOpPasswordEncoder, MessageDigestPasswordEncoder, và StandardPasswordEncoder. 
Mỗi lớp PasswordEncoder có một cách riêng để mã hóa mật khẩu và tạo ra một chuỗi mã hóa mật khẩu.

+) UserDetailsService : UserDetailsService là một interface trong Spring Security, cung cấp phương thức để tìm kiếm thông tin người dùng từ cơ sở dữ liệu 
hoặc từ bất kỳ nguồn dữ liệu nào khác. Nó là một phần quan trọng của việc xác thực người dùng trong Spring Security,
vì nó cho phép ta truy xuất thông tin người dùng từ cơ sở dữ liệu và sử dụng nó để kiểm tra xem người dùng có hợp lệ hay không.

+)  UserDetails : là một interface trong Spring Security, định nghĩa các phương thức cần thiết để đại diện cho thông tin về một người dùng trong hệ thống.
Nó cung cấp các thông tin về người dùng như tên đăng nhập, mật khẩu đã được mã hóa, các quyền truy cập của người dùng,
tài khoản đã bị khóa hay không, tài khoản đã hết hạn hay không, và các thông tin khác.

2.Dựa vào hiểu biết của em. Hãy trình bày sơ lược về workflow trong Spring Security
![image](https://user-images.githubusercontent.com/112822290/231103510-3c31848f-d00d-497d-96de-3f1b082bf64b.png)

[1]->[2]->[3] : khi người dùng gửi resquest bao gồm 2 trường username và passwword ,
SecurityFilterChain sẽ tạo ra đối tượng  UserNamePasswordAuthenticationToken (đay là 1 interface) chứa 2 trường username và password để hướng dữ liệu từ người dùng gửi lên 
nó bao gồm cả các phương thức xác thực và phân quyền . tiếp theo nó sẽ làm tham số đầu vào cho AuthenticationManager

[4]->[5] :  AuthenticationManager sẽ gọi  một hoặc nhiều AuthenticationProvider để xác thực thông tin đăng nhập của người dùng.
Mỗi AuthenticationProvider có thể hỗ trợ một hoặc nhiều cách để xác thực thông tin đăng nhập của người dùng 

[5] ->[6] : AuthenticationProvider gọi đến lớp PasswordEncoder dùng để mã hóa và so sánh mật khẩu ,
trước đó nó sẽ dùng UserDetailService để tìm kiếm User theo usernname (nếu k có throw ra Exception ) 
[6] -> [7] -> [8] : UserDetail dùng để thực thi các phương thức xác thực trạng thái của User ,
còn class User là class chứa các thông tin cơ bản dùng để truy xuất , truy vấn (có thể Custom class này )

[9] -> [6] ... : nếu xác thực thành , phân quyền thành công thì sẽ trả về cho 
AuthenticationProvider 1  đối tượng autheticationProvider rồi đối tượng này làm tham số đầu ra cho AuthenticationManager ,
tiếp theo đó sẽ được lưu trong Sercurity Context Holder còn nếu ko xác thực thành công sẽ throw ra AuthenticationException.



3.Session là gì? Cookie là gì? Nêu sự khác biệt giữa session và cookie
+)Cookie là một tập tin văn bản được lưu trữ trên máy tính của người dùng bởi trang web. Cookie được sử dụng để lưu trữ thông tin của người dùng,
chẳng hạn như tên người dùng và mật khẩu, thông tin giỏ hàng, lịch sử truy cập và các thông tin khác.
Cookie có thể được sử dụng để theo dõi hoạt động của người dùng trên trang web, nhưng cũng có thể được sử dụng để cung cấp các tính năng như lưu trữ thông tin đăng nhập để người dùng không cần phải đăng nhập lại mỗi khi truy cập trang web.

+)Session là một phiên làm việc trên máy chủ web, nơi mà thông tin về người dùng được lưu trữ.
Mỗi khi người dùng truy cập vào trang web, một phiên làm việc mới sẽ được tạo ra, và thông tin về người dùng sẽ được lưu trữ trong phiên đó. 
Session có thể được sử dụng để lưu trữ các thông tin của người dùng trong suốt phiên làm việc, chẳng hạn như các thông tin giỏ hàng hoặc lịch sử truy cập.

Sự khác biệt chính giữa Session và Cookie : 
là ở cách thức lưu trữ thông tin và thời gian lưu trữ. Cookie được lưu trữ trên máy tính của người dùng, trong khi Session được lưu trữ trên máy chủ web. Thời gian lưu trữ của Cookie có thể được thiết lập để tự động hết hạn sau một khoảng thời gian nhất định, trong khi Session sẽ tự động hết hạn khi người dùng đóng trình duyệt hoặc phiên làm việc được kết thúc.
