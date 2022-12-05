<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<header>
    <!-- Top-Header -->
    <div class="full-layer-outer-header">
        <div class="container clearfix">
            <nav>
                <ul class="primary-nav g-nav">
                    <li>
                        <a href="tel:+84819200602">
                            <i class="fas fa-phone u-c-brand u-s-m-r-9"></i>
                            Telephone:+848-81920-0602</a>
                    </li>
                    <li>
                        <a href="mailto:20110386@student.hcmute.edu.vn">
                            <i class="fas fa-envelope u-c-brand u-s-m-r-9"></i>
                            E-mail: 20110386@student.hcmute.edu.vn
                        </a>
                    </li>
                </ul>
            </nav>
            <nav>
                
                <ul class="secondary-nav g-nav">
                    <li>
                        <c:choose>
                            <c:when test="${sessionScope.logined == 'true'}">
                                <a>${sessionScope.user.name}
                                    <i class="fas fa-chevron-down u-s-m-l-9"></i>
                                </a>
                                <ul class="g-dropdown" style="width:200px">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/profile">
                                            <i class="fas fa-sign-in-alt u-s-m-r-9"></i>
                                            My Profile</a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/cart.jsp">
                                            <i class="fas fa-cog u-s-m-r-9"></i>
                                            My Cart</a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/wishlist.jsp">
                                            <i class="far fa-heart u-s-m-r-9"></i>
                                            My Wishlist</a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/logout">
                                            <i class="far fa-check-circle u-s-m-r-9"></i>
                                            Logout</a>
                                    </li>
                                </ul>
                            </c:when>
                            <c:otherwise>
                                <a href="${pageContext.request.contextPath}/account">
                                    <i class="fas fa-sign-in-alt u-s-m-r-9"></i>
                                    Login / Register</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                    <!-- <li>
                        <a>USD
                            <i class="fas fa-chevron-down u-s-m-l-9"></i>
                        </a>
                        <ul class="g-dropdown" style="width:90px">
                            <li>
                                <a href="#" class="u-c-brand">($) USD</a>
                            </li>
                            <li>
                                <a href="#">(£) GBP</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a>ENG
                            <i class="fas fa-chevron-down u-s-m-l-9"></i>
                        </a>
                        <ul class="g-dropdown" style="width:70px">
                            <li>
                                <a href="#" class="u-c-brand">ENG</a>
                            </li>
                            <li>
                                <a href="#">ARB</a>
                            </li>
                        </ul>
                    </li> -->
                </ul>
            </nav>
        </div>
    </div>
    <!-- Top-Header /- -->
    <!-- Mid-Header -->
    <div class="full-layer-mid-header">
        <div class="container">
            <div class="row clearfix align-items-center">
                <div class="col-lg-3 col-md-9 col-sm-6">
                    <div class="brand-logo text-lg-center">
                        <a href="${pageContext.request.contextPath}">
                            <img src="images/main-logo/groover-branding-1.png" alt="Groover Brand Logo" class="app-brand-logo">
                        </a>
                    </div>
                </div>
                <div class="col-lg-6 u-d-none-lg">
                    <form class="form-searchbox" action="search">
                        <label class="sr-only" for="search-landscape">Search</label>
                        <input id="search-landscape" type="text" class="text-field" placeholder="Search everything" name="term">
                        <input type="hidden" name="index" value=1>
                        <button id="btn-search" type="submit" class="button button-primary fas fa-search"></button>
                    </form>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6">
                    <nav>
                        <ul class="mid-nav g-nav">
                            <li class="u-d-none-lg">
                                <a href="${pageContext.request.contextPath}">
                                    <i class="ion ion-md-home u-c-brand"></i>
                                </a>
                            </li>
                            <li class="u-d-none-lg">
                                <a href="${pageContext.request.contextPath}/wishlist.jsp">
                                    <i class="far fa-heart"></i>
                                </a>
                            </li>
                            <li>
                                <a id="mini-cart-trigger">
                                    <i class="ion ion-md-basket"></i>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- Mid-Header /- -->
    <!-- Responsive-Buttons -->
    <div class="fixed-responsive-container">
        <div class="fixed-responsive-wrapper">
            <button type="button" class="button fas fa-search" id="responsive-search"></button>
        </div>
        <div class="fixed-responsive-wrapper">
            <a href="wishlist.jsp">
                <i class="far fa-heart"></i>
            </a>
        </div>
    </div>
    <!-- Responsive-Buttons /- -->
    <!-- Mini Cart -->
    <div class="mini-cart-wrapper">
        <div class="mini-cart">
            <div class="mini-cart-header">
                YOUR CART
                <button type="button" class="button ion ion-md-close" id="mini-cart-close"></button>
            </div>
            <ul class="mini-cart-list">
                <c:forEach var="cartItem" items="${sessionScope.user.getCart().getCartItems().getCartItems()}">
                    <c:set var="game" value="${gameDB.getGame(cartItem.getGameID())}"></c:set>
                    <li class="clearfix">
                        <a href="game?id=${game.getID()}">
                            <img src="${game.getImages().get(0)}" alt="Product">
                            <span class="mini-item-name">${game.getName()}</span>
                            <span class="mini-item-price">$${cartItem.getPrice()}</span>
                            <span class="mini-item-quantity"> x ${cartItem.getQuantity()} </span>
                        </a>
                    </li> 
                </c:forEach>
            </ul>
            <div class="mini-shop-total clearfix">
                <span class="mini-total-heading float-left">Total:</span>
                <c:choose>
                    <c:when test="${sessionScope.user.getCart().getTotal() != null}">
                        <span class="mini-total-price float-right">$${sessionScope.user.getCart().getTotal()}</span>
                    </c:when>
                    <c:otherwise>
                        <span class="mini-total-price float-right">$0</span>
                    </c:otherwise>
                </c:choose>
                
            </div>
            <div class="mini-action-anchors">
                <a href="cart.html" class="cart-anchor">View Cart</a>
                <a href="checkout.html" class="checkout-anchor">Checkout</a>
            </div>
        </div>
    </div>
    <!-- Mini Cart /- -->
    <!-- Bottom-Header -->
    <!-- <div class="full-layer-bottom-header">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-3">
                    <div class="v-menu">
                        <span class="v-title">
                            <i class="ion ion-md-menu"></i>
                            All Categories
                            <i class="fas fa-angle-down"></i>
                        </span>
                        <nav>
                            <div class="v-wrapper">
                                <ul class="v-list animated fadeIn">
                                    <li class="js-backdrop">
                                        <a href="shop-v1-root-category.html">
                                            <i class="ion ion-md-shirt"></i>
                                            Men's Clothing
                                            <i class="ion ion-ios-arrow-forward"></i>
                                        </a>
                                        <button class="v-button ion ion-md-add"></button>
                                        <div class="v-drop-right" style="width: 700px;">
                                            <div class="row">
                                                <div class="col-lg-4">
                                                    <ul class="v-level-2">
                                                        <li>
                                                            <a href="shop-v2-sub-category.html">Tops</a>
                                                            <ul>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">T-Shirts</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Hoodies</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Suits</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v4-filter-as-category.html">Black Bean T-Shirt
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="col-lg-4">
                                                    <ul class="v-level-2">
                                                        <li>
                                                            <a href="shop-v2-sub-category.html">Outwear</a>
                                                            <ul>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Jackets</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Trench</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Parkas</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Sweaters</a>
                                                                </li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="col-lg-4">
                                                    <ul class="v-level-2">
                                                        <li>
                                                            <a href="shop-v1-root-category.html">Accessories</a>
                                                            <ul>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Watches</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Ties</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Scarves</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Belts</a>
                                                                </li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-lg-4">
                                                    <ul class="v-level-2">
                                                        <li>
                                                            <a href="shop-v2-sub-category.html">Bottoms</a>
                                                            <ul>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Casual Pants
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Shoes</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Jeans</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Shorts</a>
                                                                </li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="col-lg-4">
                                                    <ul class="v-level-2">
                                                        <li>
                                                            <a href="shop-v2-sub-category.html">Underwear</a>
                                                            <ul>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Boxers</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Briefs</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Robes</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Socks</a>
                                                                </li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="col-lg-4">
                                                    <ul class="v-level-2">
                                                        <li>
                                                            <a href="shop-v2-sub-category.html">Sunglasses</a>
                                                            <ul>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Pilot</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Wayfarer</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Square</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Round</a>
                                                                </li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="js-backdrop">
                                        <a href="shop-v1-root-category.html">
                                            <i class="ion ion-ios-shirt"></i>
                                            Women's Clothing
                                            <i class="ion ion-ios-arrow-forward"></i>
                                        </a>
                                        <button class="v-button ion ion-md-add"></button>
                                        <div class="v-drop-right" style="width: 700px;">
                                            <div class="row">
                                                <div class="col-lg-4">
                                                    <ul class="v-level-2">
                                                        <li>
                                                            <a href="shop-v2-sub-category.html">Tops</a>
                                                            <ul>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Dresses</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Blouses & Shirts
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">T-shirts</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Sweater</a>
                                                                </li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="col-lg-4">
                                                    <ul class="v-level-2">
                                                        <li>
                                                            <a href="shop-v2-sub-category.html">Intimates</a>
                                                            <ul>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Bras</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Brief Sets
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Bustiers & Corsets
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Panties</a>
                                                                </li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="col-lg-4">
                                                    <ul class="v-level-2">
                                                        <li>
                                                            <a href="shop-v2-sub-category.html">Wedding & Events
                                                            </a>
                                                            <ul>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Wedding Dresses
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v2-sub-category.html">Evening Dresses
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Prom Dresses
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Flower Dresses
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-lg-4">
                                                    <ul class="v-level-2">
                                                        <li>
                                                            <a href="shop-v2-sub-category.html">Bottoms</a>
                                                            <ul>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Skirts</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Shoes</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Leggings</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Jeans</a>
                                                                </li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="col-lg-4">
                                                    <ul class="v-level-2">
                                                        <li>
                                                            <a href="shop-v2-sub-category.html">Outwear & Jackets
                                                            </a>
                                                            <ul>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Blazers</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Basics Jackets
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Trench</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Leather & Suede
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="col-lg-4">
                                                    <ul class="v-level-2">
                                                        <li>
                                                            <a href="shop-v2-sub-category.html">Accessories</a>
                                                            <ul>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Sunglasses</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Headwear</a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Baseball Caps
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Belts</a>
                                                                </li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="js-backdrop">
                                        <a href="shop-v1-root-category.html">
                                            <i class="ion ion-md-rocket"></i>
                                            Toys Hobbies & Robots
                                            <i class="ion ion-ios-arrow-forward"></i>
                                        </a>
                                        <button class="v-button ion ion-md-add"></button>
                                        <div class="v-drop-right" style="width: 700px;">
                                            <div class="row">
                                                <div class="col-lg-4">
                                                    <ul class="v-level-2">
                                                        <li>
                                                            <a href="shop-v2-sub-category.html">RC Toys & Hobbies
                                                            </a>
                                                            <ul>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">RC Helicopter
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">RC Lego Robots
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">RC Drone
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">RC Car
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">RC Boat
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">RC Robot
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Multi Rotor Parts
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">FPV System
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Radios & Receiver
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Battery & Charger
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="col-lg-4">
                                                    <ul class="v-level-2">
                                                        <li>
                                                            <a href="shop-v2-sub-category.html">Solar Energy
                                                            </a>
                                                            <ul>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Solar Powered Toy
                                                                    </a>
                                                                </li>
                                                                <li>
                                                                    <a href="shop-v3-sub-sub-category.html">Solar Powered System
                                                                    </a>
                                                                </li>
                                                                <li class="view-more-flag">
                                                                    <a href="store-directory.html">View More
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div> -->
                                            <!-- Remember layer image should be place on empty space and its not overlap your list items because user could not read your list items. -->
                                            <!-- <div class="v-image" style="bottom: 0;right: -25px">
                                                <a href="#" class="d-block">
                                                    <img src="images/banners/mega-3.png" class="img-fluid" alt="Product">
                                                </a>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a href="shop-v1-root-category.html">
                                            <i class="ion ion-md-phone-portrait"></i>
                                            Mobiles & Tablets
                                        </a>
                                    </li>
                                    <li>
                                        <a href="shop-v1-root-category.html">
                                            <i class="ion ion-md-tv"></i>
                                            Consumer Electronics
                                        </a>
                                    </li>
                                    <li>
                                        <a href="shop-v1-root-category.html">
                                            <i class="ion ion-ios-book"></i>
                                            Books & Audible
                                        </a>
                                    </li>
                                    <li>
                                        <a href="shop-v1-root-category.html">
                                            <i class="ion ion-md-heart"></i>
                                            Beauty & Health
                                        </a>
                                    </li>
                                    <li class="v-none" style="display: none">
                                        <a href="shop-v1-root-category.html">
                                            <i class="ion ion-md-easel"></i>
                                            Furniture Home & Office
                                        </a>
                                    </li>
                                    <li>
                                        <a class="v-more">
                                            <i class="ion ion-md-add"></i>
                                            <span>View More</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
                <div class="col-lg-9">
                    <ul class="bottom-nav g-nav u-d-none-lg">
                        <li>
                            <a href="custom-deal-page.html">New Arrivals
                                <span class="superscript-label-new">NEW</span>
                            </a>
                        </li>
                        <li>
                            <a href="custom-deal-page.html">Exclusive Deals
                                <span class="superscript-label-hot">HOT</span>
                            </a>
                        </li>
                        <li>
                            <a href="custom-deal-page.html">Flash Deals
                            </a>
                        </li>
                        <li class="mega-position">
                            <a>Pages
                                <i class="fas fa-chevron-down u-s-m-l-9"></i>
                            </a>
                            <div class="mega-menu mega-3-colm">
                                <ul>
                                    <li class="menu-title">Home & Static Pages</li>
                                    <li>
                                        <a href="/home" class="u-c-brand">Home</a>
                                    </li>
                                    <li>
                                        <a href="about.html">About</a>
                                    </li>
                                    <li>
                                        <a href="contact.html">Contact</a>
                                    </li>
                                    <li>
                                        <a href="faq.html">FAQ</a>
                                    </li>
                                    <li>
                                        <a href="store-directory.html">Store Directory</a>
                                    </li>
                                    <li>
                                        <a href="terms-and-conditions.html">Terms & Conditions</a>
                                    </li>
                                    <li>
                                        <a href="404.html">404</a>
                                    </li>
                                    <li class="menu-title">Single Product Page</li>
                                    <li>
                                        <a href="single-product.html">Single Product Fullwidth</a>
                                    </li>
                                    <li class="menu-title">Blog</li>
                                    <li>
                                        <a href="blog.html">Blog Page</a>
                                    </li>
                                    <li>
                                        <a href="blog-detail.html">Blog Details</a>
                                    </li>
                                </ul>
                                <ul>
                                    <li class="menu-title">Ecommerce Pages</li>
                                    <li>
                                        <a href="shop-v2-sub-category.html">Shop</a>
                                    </li>
                                    <li>
                                        <a href="cart.html">Cart</a>
                                    </li>
                                    <li>
                                        <a href="checkout.html">Checkout</a>
                                    </li>
                                    <li>
                                        <a href="account.html">My Account</a>
                                    </li>
                                    <li>
                                        <a href="wishlist.html">Wishlist</a>
                                    </li>
                                    <li>
                                        <a href="track-order.html">Track your Order</a>
                                    </li>
                                    <li class="menu-title">Cart Variations</li>
                                    <li>
                                        <a href="cart-empty.html">Cart Ver 1 Empty</a>
                                    </li>
                                    <li>
                                        <a href="cart.html">Cart Ver 2 Full</a>
                                    </li>
                                    <li class="menu-title">Wishlist Variations</li>
                                    <li>
                                        <a href="wishlist-empty.html">Wishlist Ver 1 Empty</a>
                                    </li>
                                    <li>
                                        <a href="wishlist.html">Wishlist Ver 2 Full</a>
                                    </li>
                                </ul>
                                <ul>
                                    <li class="menu-title">Shop Variations</li>
                                    <li>
                                        <a href="shop-v1-root-category.html">Shop Ver 1 Root Category</a>
                                    </li>
                                    <li>
                                        <a href="shop-v2-sub-category.html">Shop Ver 2 Sub Category</a>
                                    </li>
                                    <li>
                                        <a href="shop-v3-sub-sub-category.html">Shop Ver 3 Sub Sub Category</a>
                                    </li>
                                    <li>
                                        <a href="shop-v4-filter-as-category.html">Shop Ver 4 Filter as Category</a>
                                    </li>
                                    <li>
                                        <a href="shop-v5-product-not-found.html">Shop Ver 5 Product Not Found</a>
                                    </li>
                                    <li>
                                        <a href="shop-v6-search-results.html">Shop Ver 6 Search Results</a>
                                    </li>
                                    <li class="menu-title">My Account Variation</li>
                                    <li>
                                        <a href="lost-password.html">Lost Your Password ?</a>
                                    </li>
                                    <li class="menu-title">Checkout Variation</li>
                                    <li>
                                        <a href="confirmation.html">Checkout Confirmation</a>
                                    </li>
                                    <li class="menu-title">Custom Deals Page</li>
                                    <li>
                                        <a href="custom-deal-page.html">Custom Deal Page</a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li>
                            <a href="custom-deal-page.html">Super Sale
                                <span class="superscript-label-discount">-15%</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div> -->
    <!-- Bottom-Header /- -->
</header>