<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles1.css">

    <title>Office Theme | Electronic Store</title>
</head>
<body>
<header>
    <h1>Welcome to our Electronic Store</h1>
</header>

<nav>
    <ul>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="registration.jsp">Sign Up</a></li>
        <li><a href="#search">Search & Explore</a></li>
        <li><a href="ProductDetailsServlet">Products</a></li>
        <li><a href="registerProduct.jsp">Admin Register Product</a></li>
        <li><a href="PlaceOrderForm.jsp">Place Order</a></li>

        <% if (session.getAttribute("customerId") != null) { %>
        <li class="welcome-message">Welcome, <%= session.getAttribute("customerFullName") %></li>
        <% } %>
    </ul>
</nav>

<section id="main-content">
    <!-- Content will be dynamically loaded based on user interaction -->
    <h2>Discover the Future of Technology</h2>
    <p>Join our community of tech enthusiasts and stay up-to-date with the latest trends in electronics. Sign up to unlock exclusive benefits and personalized recommendations.</p>

    <p>Navigate through our extensive catalog to find the perfect electronic products that suit your needs. From cutting-edge gadgets to reliable appliances, we've got it all.</p>

    <p>Explore a diverse range of high-quality electronic products. Whether you're a tech aficionado or a casual shopper, our curated selection caters to every preference.</p>

    <p>Are you a product creator or distributor? Register your electronic products with us to showcase them to a global audience. Our platform provides exposure to a vast customer base.</p>

    <p>Enjoy a seamless shopping experience. Place orders effortlessly and track your purchases in real-time. Our user-friendly interface ensures a hassle-free checkout process.</p>

    <p>Experience personalized service. As a valued member, enjoy special promotions, early access to new arrivals, and tailored recommendations based on your preferences.</p>

    <p>Empower yourself with knowledge. Explore our educational resources to stay informed about the latest advancements in technology. We believe in sharing knowledge to inspire innovation.</p>

    <p>Conveniently receive PDF receipts for your purchases. Stay organized and have easy access to your order details. Our commitment to transparency ensures a trustworthy shopping experience.</p>

    <h3>Join Us on the Journey of Innovation</h3>
    <p>We are more than just an electronic store. We are a community driven by passion for technology. Join us in embracing the future. Explore. Learn. Shop.</p>

    <p>Ready to embark on a journey of innovation? Start exploring our electronic store now!</p>
</section>

<footer>
    <p>&copy; 2023 Electronic Store. All rights reserved.</p>
</footer>
</body>
</html>
