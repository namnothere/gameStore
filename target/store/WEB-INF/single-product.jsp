<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="no-js" lang="en-US">

<head>
    <meta charset="UTF-8">
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <![endif]-->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Groover - Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more</title>
    <!-- Standard Favicon -->
    <link href="favicon.ico" rel="shortcut icon">
    <!-- Base Google Font for Web-app -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
    <!-- Google Fonts for Banners only -->
    <link href="https://fonts.googleapis.com/css?family=Raleway:400,800" rel="stylesheet">
    <!-- Bootstrap 4 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Font Awesome 5 -->
    <link rel="stylesheet" href="css/fontawesome.min.css">
    <!-- Ion-Icons 4 -->
    <link rel="stylesheet" href="css/ionicons.min.css">
    <!-- Animate CSS -->
    <link rel="stylesheet" href="css/animate.min.css">
    <!-- Owl-Carousel -->
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <!-- Jquery-Ui-Range-Slider -->
    <link rel="stylesheet" href="css/jquery-ui-range-slider.min.css">
    <!-- Utility -->
    <link rel="stylesheet" href="css/utility.css">
    <!-- Main -->
    <link rel="stylesheet" href="css/bundle.css">
    <!-- <link rel="stylesheet" href="css/bundle.blue.css"> -->
</head>

<body>

<!-- app -->
<!-- <div id="app"> -->
<div id="app">
    <!-- Header -->
    <header>
        <!-- Top-Header -->
        <div class="full-layer-outer-header">
            <div class="container clearfix">
                <nav>
                    <ul class="primary-nav g-nav">
                        <li>
                            <a href="tel:+111444989">
                                <i class="fas fa-phone u-c-brand u-s-m-r-9"></i>
                                Telephone:+111-444-989</a>
                        </li>
                        <li>
                            <a href="mailto:contact@domain.com">
                                <i class="fas fa-envelope u-c-brand u-s-m-r-9"></i>
                                E-mail: contact@domain.com
                            </a>
                        </li>
                    </ul>
                </nav>
                <nav>
                    <ul class="secondary-nav g-nav">
                        <li>
                            <a href="${pageContext.request.contextPath}/myaccount">My Account<i class="fas fa-chevron-down u-s-m-l-9"></i>
                            </a>
                            <!-- <a>
                                My account1
                            </a> -->
                            <ul class="g-dropdown" style="width:200px">
                                <li>
                                    <a href="cart.html">
                                        <i class="fas fa-cog u-s-m-r-9"></i>
                                        My Cart</a>
                                </li>
                                <li>
                                    <a href="wishlist.html">
                                        <i class="far fa-heart u-s-m-r-9"></i>
                                        My Wishlist</a>
                                </li>
                                <li>
                                    <a href="checkout.html">
                                        <i class="far fa-check-circle u-s-m-r-9"></i>
                                        Checkout</a>
                                </li>
                                <li>
                                    <a href="account.html">
                                        <i class="fas fa-sign-in-alt u-s-m-r-9"></i>
                                        Login / Signup</a>
                                </li>
                            </ul>
                        </li>
                        <li>
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
                            <a href="home.html">
                                <img src="images/main-logo/groover-branding-1.png" alt="Groover Brand Logo" class="app-brand-logo">
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-6 u-d-none-lg">
                        <form class="form-searchbox">
                            <label class="sr-only" for="search-landscape">Search</label>
                            <input id="search-landscape" type="text" class="text-field" placeholder="Search everything">
                            <div class="select-box-position">
                                <div class="select-box-wrapper select-hide">
                                    <label class="sr-only" for="select-category">Choose category for search</label>
                                    <select class="select-box" id="select-category">
                                        <option selected="selected" value="">
                                            All
                                        </option>
                                        <option value="">Men's Clothing</option>
                                        <option value="">Women's Clothing
                                        </option>
                                        <option value="">Toys Hobbies & Robots
                                        </option>
                                        <option value="">Mobiles & Tablets
                                        </option>
                                        <option value="">Consumer Electronics
                                        </option>
                                        <option value="">Books & Audible
                                        </option>
                                        <option value="">Beauty & Health
                                        </option>
                                        <option value="">Furniture Home & Office
                                        </option>
                                    </select>
                                </div>
                            </div>
                            <button id="btn-search" type="submit" class="button button-primary fas fa-search"></button>
                        </form>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-6">
                        <nav>
                            <ul class="mid-nav g-nav">
                                <li class="u-d-none-lg">
                                    <a href="home.html">
                                        <i class="ion ion-md-home"></i>
                                    </a>
                                </li>
                                <li class="u-d-none-lg">
                                    <a href="wishlist.html">
                                        <i class="far fa-heart"></i>
                                    </a>
                                </li>
                                <li>
                                    <a id="mini-cart-trigger">
                                        <i class="ion ion-md-basket"></i>
                                        <span class="item-counter">4</span>
                                        <span class="item-price">$220.00</span>
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
                <a href="wishlist.html">
                    <i class="far fa-heart"></i>
                    <span class="fixed-item-counter">4</span>
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
                    <li class="clearfix">
                        <a href="single-product.html">
                            <img src="images/product/product@1x.jpg" alt="Product">
                            <span class="mini-item-name">Casual Hoodie Full Cotton</span>
                            <span class="mini-item-price">$55.00</span>
                            <span class="mini-item-quantity"> x 1 </span>
                        </a>
                    </li>
                    <li class="clearfix">
                        <a href="single-product.html">
                            <img src="images/product/product@1x.jpg" alt="Product">
                            <span class="mini-item-name">Black Rock Dress with High Jewelery Necklace</span>
                            <span class="mini-item-price">$55.00</span>
                            <span class="mini-item-quantity"> x 1 </span>
                        </a>
                    </li>
                    <li class="clearfix">
                        <a href="single-product.html">
                            <img src="images/product/product@1x.jpg" alt="Product">
                            <span class="mini-item-name">Xiaomi Note 2 Black Color</span>
                            <span class="mini-item-price">$55.00</span>
                            <span class="mini-item-quantity"> x 1 </span>
                        </a>
                    </li>
                    <li class="clearfix">
                        <a href="single-product.html">
                            <img src="images/product/product@1x.jpg" alt="Product">
                            <span class="mini-item-name">Dell Inspiron 15</span>
                            <span class="mini-item-price">$55.00</span>
                            <span class="mini-item-quantity"> x 1 </span>
                        </a>
                    </li>
                </ul>
                <div class="mini-shop-total clearfix">
                    <span class="mini-total-heading float-left">Total:</span>
                    <span class="mini-total-price float-right">$220.00</span>
                </div>
                <div class="mini-action-anchors">
                    <a href="cart.html" class="cart-anchor">View Cart</a>
                    <a href="checkout.html" class="checkout-anchor">Checkout</a>
                </div>
            </div>
        </div>
        <!-- Mini Cart /- -->
        <!-- Bottom-Header -->
        <div class="full-layer-bottom-header">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-3">
                        <div class="v-menu v-close">
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
                                                </div>
                                                <!-- Remember layer image should be place on empty space and its not overlap your list items because user could not read your list items. -->
                                                <div class="v-image" style="bottom: 0;right: -25px">
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
                                        <!-- <li>
                                            <a class="v-more">
                                                <i class="ion ion-md-add"></i>
                                                <span>View More</span>
                                            </a>
                                        </li> -->
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
                                            <a href="home.html">Home</a>
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
                                            <a href="single-product.html" class="u-c-brand">Single Product Fullwidth</a>
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
        </div>
        <!-- Bottom-Header /- -->
    </header>
    <!-- Header /- -->
    <!-- Single-Product-Full-Width-Page -->
    <div class="page-detail u-s-p-t-40">
        <div class="container">
            <!-- Product-Detail -->
            <div class="row pb-2">
                <!-- <div class="col-lg-6 col-md-12 col-sm-12"> -->
                <div class="col-lg-12">
                    
                    <!-- Breadcrumb -->
                    <nav aria-label="breadcrumb" class="main-breadcrumb">
                        <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="home.html">Home</a></li>
                        <!-- <li class="breadcrumb-item"><a href="javascript:void(0)">User</a></li> -->
                        <li class="breadcrumb-item"><a href="shop-v1-root-category.html">Men's Clothing</a></li>
                        <li class="breadcrumb-item active"><a href="shop-v3-sub-sub-category.html">Hoodies</a></li>
                        <!-- <li class="breadcrumb-item active" aria-current="page">Profile Settings</li> -->
                        </ol>
                        <style>
                            ol.breadcrumb {
                            background-color: #272E48;
                            /* background-color: #CECAC3; */
                            }
                            ol.breadcrumb li a {
                                color: #CECAC3;
                            }
                            .breadcrumb a:hover {
                                color: #d90429; }
                        </style>
                    </nav>
                    <!-- /Breadcrumb -->
                    <!-- <ul class="bread-crumb">
                        <li class="has-separator">
                            <a href="home.html">Home</a>
                        </li>
                        <li class="has-separator">
                            <a href="shop-v1-root-category.html">Men's Clothing</a>
                        </li>
                        <li class="has-separator">
                            <a href="shop-v2-sub-category.html">Tops</a>
                        </li>
                        <li class="is-marked">
                            <a href="shop-v3-sub-sub-category.html">Hoodies</a>
                        </li>
                    </ul> -->
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <!-- Product-zoom-area -->
                    <div class="zoom-area">
                        <img id="zoom-pro" class="img-fluid" src="${game.getImages().get(0)}" data-zoom-image="${game.getImages().get(0)}" alt="Zoom Image">
                        <div id="gallery" class="u-s-m-t-10">
                            <a class="active" data-image="${game.getImages().get(0)}" data-zoom-image="${game.getImages().get(0)}">
                                <img src="${game.getImages().get(0)}" alt="Product">
                            </a>
                            <c:forEach var="image" items="${game.getImages()}" varStatus="state">
                                <c:if test="${not state.first}">
                                    <a data-image="${image}" data-zoom-image="${image}">
                                        <img src="${image}" alt="Product">
                                    </a>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                    <!-- Product-zoom-area /- -->
                </div>
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <!-- Product-details -->
                    <div class="all-information-wrapper">
                        <div class="section-1-title-breadcrumb-rating">
                            <div class="product-title">
                                <h1>
                                    <p>${game.getName()}</p>
                                </h1>
                            </div>
                            <div class="product-rating">
                                <div class='star' title= "${game.getRating()} out of 5">
                                    <span style='width:67px'></span>
                                </div>
                            </div>
                        </div>
                        <div class="section-2-short-description u-s-p-y-14">
                            <!-- <h6 class="information-heading u-s-m-b-8">Description:</h6> -->
                            <div class="description">
                                <span>Description:</span>
                                <span>${game.getDesc()} VND</span>
                            </div>
                            <div class="publisher">
                                <span>Publisher: </span>
                                <c:forEach var="publisher" items="${game.getPublishers()}"><span>${publisher}, </span></c:forEach>
                            </div>
                            <div class="developer">
                                <span>Developer: </span>
                                <c:forEach var="developer" items="${game.getDevelopers()}"><span>${developer}, </span></c:forEach>
                            </div>
                            <div class="release-date">
                                <span>Release date: ${game.getReleaseDate()}</span>
                            </div>
                            <div class="genre">
                                <span>Genre: </span>
                                <c:forEach var="genre" items="${game.getGenres()}"><span>${genre.getDescription()}, </span></c:forEach>
                            </div>
                            <div class="category">
                                <span>Category: </span>
                                <c:forEach var="category" items="${game.getCategories()}"><span>${category.getDescription()}, </span></c:forEach>
                            </div>
                        </div>
                        <div class="section-3-price-original-discount u-s-p-y-14">
                            <div class="price">
                                <h4>${game.getFinalPrice()} USD</h4>
                            </div>
                            <div class="original-price">
                                <span>Original Price:</span>
                                <span>${game.getInitialPrice()} USD</span>
                            </div>
                            <div class="total-save">
                                <span>Save:</span>
                                <span>${game.getInitialPrice() - game.getFinalPrice()} USD</span>
                            </div>
                        </div>
                                <div>
                                    <button class="button button-outline-secondary" type="submit">Add to cart</button>
                                    <button class="button button-outline-secondary far fa-heart u-s-m-l-6"></button>
                                    <button class="button button-outline-secondary far fa-envelope u-s-m-l-6"></button>
                                </div>
                        </div>
                    </div>
                    <!-- Product-details /- -->
                </div>
            </div>
            <!-- Product-Detail /- -->
            <!-- Different-Product-Section -->
            <div class="detail-different-product-section u-s-p-t-80">
                <!-- Similar-Products -->
                <section class="section-maker">
                    <div class="container">
                        <div class="sec-maker-header text-center">
                            <h3 class="sec-maker-h3">Similar Games</h3>
                        </div>
                        <div class="slider-fouc">
                            <div class="products-slider owl-carousel" data-item="4">
                                <c:forEach var="game" items="${similarGames}">
                                    <div class="item">
                                        <div class="image-container">
                                            <a class="item-img-wrapper-link" href="game?id=${game.ID}">
                                                <img class="img-fluid" src="${game.images.get(0)}" alt="Product">
                                            </a>
                                            <div class="item-action-behaviors">
                                                <a class="item-quick-look" data-toggle="modal" href="#quick-view">Quick Look</a>
                                                <a class="item-mail" href="javascript:void(0)">Mail</a>
                                                <a class="item-addwishlist" href="javascript:void(0)">Add to Wishlist</a>
                                                <a class="item-addCart" href="javascript:void(0)">Add to Cart</a>
                                            </div>
                                        </div>
                                        <div class="item-content">
                                            <div class="what-product-is">
                                                <!-- <ul class="bread-crumb">
                                                    <li class="has-separator">
                                                        <a href="shop-v1-root-category.html">Men's</a>
                                                    </li>
                                                    <li class="has-separator">
                                                        <a href="shop-v2-sub-category.html">Tops</a>
                                                    </li>
                                                    <li>
                                                        <a href="shop-v3-sub-sub-category.html">Hoodies</a>
                                                    </li>
                                                </ul> -->
                                                <h6 class="item-title">
                                                    <a href="game?id=${game.ID}">${game.name}</a>
                                                </h6>
                                                <div class="item-stars">
                                                    <div class='star' title="${game.rating} out of 5 - based on 0 Reviews">
                                                        <span style='width:0'></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="price-template">
                                                <c:if test="${not game.isIsFree()}">
                                                    <div class="item-new-price">
                                                        ${game.getInitialPrice()} USD
                                                    </div>
                                                </c:if> 
                                                <c:if test="${game.isIsFree()}">
                                                    <div class="item-new-price">
                                                        Free
                                                    </div>
                                                </c:if> 

                                                <c:if test="${game.getInitialPrice() != game.getFinalPrice()}" >
                                                    <div class="item-old-price">
                                                        ${game.getFinalPrice()} USD 
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                        <div class="tag new">
                                            <span>NEW</span>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- Similar-Products /- -->
                <!-- Recently-View-Products  -->
                <!-- <section class="section-maker">
                    <div class="container">
                        <div class="sec-maker-header text-center">
                            <h3 class="sec-maker-h3">Recently View</h3>
                        </div>
                        <div class="slider-fouc">
                            <div class="products-slider owl-carousel" data-item="4">
                                <div class="item">
                                    <div class="image-container">
                                        <a class="item-img-wrapper-link" href="single-product.html">
                                            <img class="img-fluid" src="images/product/product@3x.jpg" alt="Product">
                                        </a>
                                        <div class="item-action-behaviors">
                                            <a class="item-quick-look" data-toggle="modal" href="#quick-view">Quick Look</a>
                                            <a class="item-mail" href="javascript:void(0)">Mail</a>
                                            <a class="item-addwishlist" href="javascript:void(0)">Add to Wishlist</a>
                                            <a class="item-addCart" href="javascript:void(0)">Add to Cart</a>
                                        </div>
                                    </div>
                                    <div class="item-content">
                                        <div class="what-product-is">
                                            <ul class="bread-crumb">
                                                <li class="has-separator">
                                                    <a href="shop-v1-root-category.html">Men's</a>
                                                </li>
                                                <li class="has-separator">
                                                    <a href="shop-v2-sub-category.html">Outwear</a>
                                                </li>
                                                <li>
                                                    <a href="shop-v3-sub-sub-category.html">Jackets</a>
                                                </li>
                                            </ul>
                                            <h6 class="item-title">
                                                <a href="single-product.html">Maire Battlefield Jeep Men's Jacket</a>
                                            </h6>
                                            <div class="item-stars">
                                                <div class='star' title="0 out of 5 - based on 0 Reviews">
                                                    <span style='width:0'></span>
                                                </div>
                                                <span>(0)</span>
                                            </div>
                                        </div>
                                        <div class="price-template">
                                            <div class="item-new-price">
                                                $55.00
                                            </div>
                                            <div class="item-old-price">
                                                $60.00
                                            </div>
                                        </div>
                                    </div>
                                    <div class="tag hot">
                                        <span>HOT</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section> -->
                <!-- Recently-View-Products /- -->
            </div>
            <!-- Different-Product-Section /- -->
        </div>
    <!-- Single-Product-Full-Width-Page /- -->
    <!-- Footer -->
    <footer class="footer">
        <div class="container">
            <!-- Outer-Footer -->
            <div class="outer-footer-wrapper u-s-p-y-80">
                <h6>
                    For special offers and other discount information
                </h6>
                <h1>
                    Subscribe to our Newsletter
                </h1>
                <p>
                    Subscribe to the mailing list to receive updates on promotions, new arrivals, discount and coupons.
                </p>
                <form class="newsletter-form">
                    <label class="sr-only" for="newsletter-field">Enter your Email</label>
                    <input type="text" id="newsletter-field" placeholder="Your Email Address">
                    <button type="submit" class="button">SUBMIT</button>
                </form>
            </div>
            <!-- Outer-Footer /- -->
            <!-- Mid-Footer -->
            <div class="mid-footer-wrapper u-s-p-b-80">
                <div class="row">
                    <div class="col-lg-3 col-md-3 col-sm-12">
                        <div class="footer-list">
                            <h6>CUSTOMER SERVICE</h6>
                            <ul>
                                <li>
                                    <a href="faq.html">FAQs</a>
                                </li>
                                <li>
                                    <a href="track-order.html">Track Order</a>
                                </li>
                                <li>
                                    <a href="terms-and-conditions.html">Terms & Conditions</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-12">
                        <div class="footer-list">
                            <h6>COMPANY</h6>
                            <ul>
                                <li>
                                    <a href="home.html">Home</a>
                                </li>
                                <li>
                                    <a href="about.html">About</a>
                                </li>
                                <li>
                                    <a href="contact.html">Contact</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-12">
                        <div class="footer-list">
                            <h6>INFORMATION</h6>
                            <ul>
                                <li>
                                    <a href="store-directory.html">Categories Directory</a>
                                </li>
                                <li>
                                    <a href="wishlist.html">My Wishlist</a>
                                </li>
                                <li>
                                    <a href="cart.html">My Cart</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-12">
                        <div class="footer-list">
                            <h6>Address</h6>
                            <ul>
                                <li>
                                    <i class="fas fa-location-arrow u-s-m-r-9"></i>
                                    <span>819 Sugar Camp Road, West Concord, MN 55985</span>
                                </li>
                                <li>
                                    <a href="tel:+923086561801">
                                        <i class="fas fa-phone u-s-m-r-9"></i>
                                        <span>+111-444-989</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="mailto:contact@domain.com">
                                        <i class="fas fa-envelope u-s-m-r-9"></i>
                                        <span>
                                            contact@domain.com</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Mid-Footer /- -->
            <!-- Bottom-Footer -->
            <div class="bottom-footer-wrapper">
                <div class="social-media-wrapper">
                    <ul class="social-media-list">
                        <li>
                            <a href="#">
                                <i class="fab fa-facebook-f"></i>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fab fa-twitter"></i>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fab fa-google-plus-g"></i>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fas fa-rss"></i>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fab fa-pinterest"></i>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fab fa-linkedin-in"></i>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fab fa-youtube"></i>
                            </a>
                        </li>
                    </ul>
                </div>
                <p class="copyright-text">Copyright &copy; 2018
                    <a href="home.html">Groover</a> All Right Reserved</p>
            </div>
        </div>
        <!-- Bottom-Footer /- -->
    </footer>
    <!-- Footer /- -->
    <!-- Dummy Selectbox -->
    <div class="select-dummy-wrapper">
        <select id="compute-select">
            <option id="compute-option">All</option>
        </select>
    </div>
    <!-- Dummy Selectbox /- -->
    <!-- Responsive-Search -->
    <div class="responsive-search-wrapper">
        <button type="button" class="button ion ion-md-close" id="responsive-search-close-button"></button>
        <div class="responsive-search-container">
            <div class="container">
                <p>Start typing and press Enter to search</p>
                <form class="responsive-search-form">
                    <label class="sr-only" for="search-text">Search</label>
                    <input id="search-text" type="text" class="responsive-search-field" placeholder="PLEASE SEARCH">
                    <i class="fas fa-search"></i>
                </form>
            </div>
        </div>
    </div>
    <!-- Responsive-Search /- -->
    <!-- Quick-view-Modal -->
    <div id="quick-view" class="modal fade">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <button type="button" class="button dismiss-button ion ion-ios-close" data-dismiss="modal"></button>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-12">
                            <!-- Product-zoom-area -->
                            <div class="zoom-area">
                                <img id="zoom-pro-quick-view" class="img-fluid" src="images/product/product@4x.jpg" data-zoom-image="images/product/product@4x.jpg" alt="Zoom Image">
                                <div id="gallery-quick-view" class="u-s-m-t-10">
                                    <a class="active" data-image="images/product/product@4x.jpg" data-zoom-image="images/product/product@4x.jpg">
                                        <img src="images/product/product@2x.jpg" alt="Product">
                                    </a>
                                    <a data-image="images/product/product@4x.jpg" data-zoom-image="images/product/product@4x.jpg">
                                        <img src="images/product/product@2x.jpg" alt="Product">
                                    </a>
                                    <a data-image="images/product/product@4x.jpg" data-zoom-image="images/product/product@4x.jpg">
                                        <img src="images/product/product@2x.jpg" alt="Product">
                                    </a>
                                    <a data-image="images/product/product@4x.jpg" data-zoom-image="images/product/product@4x.jpg">
                                        <img src="images/product/product@2x.jpg" alt="Product">
                                    </a>
                                    <a data-image="images/product/product@4x.jpg" data-zoom-image="images/product/product@4x.jpg">
                                        <img src="images/product/product@2x.jpg" alt="Product">
                                    </a>
                                    <a data-image="images/product/product@4x.jpg" data-zoom-image="images/product/product@4x.jpg">
                                        <img src="images/product/product@2x.jpg" alt="Product">
                                    </a>
                                </div>
                            </div>
                            <!-- Product-zoom-area /- -->
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-12">
                            <!-- Product-details -->
                            <div class="all-information-wrapper">
                                <div class="section-1-title-breadcrumb-rating">
                                    <div class="product-title">
                                        <h1>
                                            <a href="single-product.html">Casual Hoodie Full Cotton</a>
                                        </h1>
                                    </div>
                                    <ul class="bread-crumb">
                                        <li class="has-separator">
                                            <a href="home.html">Home</a>
                                        </li>
                                        <li class="has-separator">
                                            <a href="shop-v1-root-category.html">Men's Clothing</a>
                                        </li>
                                        <li class="has-separator">
                                            <a href="shop-v2-sub-category.html">Tops</a>
                                        </li>
                                        <li class="is-marked">
                                            <a href="shop-v3-sub-sub-category.html">Hoodies</a>
                                        </li>
                                    </ul>
                                    <div class="product-rating">
                                        <div class='star' title="4.5 out of 5 - based on 23 Reviews">
                                            <span style='width:67px'></span>
                                        </div>
                                        <span>(23)</span>
                                    </div>
                                </div>
                                <div class="section-2-short-description u-s-p-y-14">
                                    <!-- <h6 class="information-heading u-s-m-b-8">Description:</h6> -->
                                    <p>This hoodie is full cotton. It includes a muff sewn onto the lower front, and (usually) a drawstring to adjust the hood opening. Throughout the U.S., it is common for middle-school, high-school, and college students to wear this sweatshirts—with or without hoods—that display their respective school names or mascots across the chest, either as part of a uniform or personal preference.
                                    </p>
                                </div>
                                <div class="section-3-price-original-discount u-s-p-y-14">
                                    <div class="price">
                                        <h4>$55.00</h4>
                                    </div>
                                    <div class="original-price">
                                        <span>Original Price:</span>
                                        <span>$60.00</span>
                                    </div>
                                    <div class="discount-price">
                                        <span>Discount:</span>
                                        <span>8%</span>
                                    </div>
                                    <div class="total-save">
                                        <span>Save:</span>
                                        <span>$5</span>
                                    </div>
                                </div>
                                        <div>
                                            <button class="button button-outline-secondary" type="submit">Add to cart</button>
                                            <button class="button button-outline-secondary far fa-heart u-s-m-l-6"></button>
                                            <button class="button button-outline-secondary far fa-envelope u-s-m-l-6"></button>
                                        </div>
                                <!-- </div> -->
                            </div>
                            <!-- Product-details /- -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Quick-view-Modal /- -->
</div>
<!-- app /- -->
<!-- [if lte IE 9]> -->
<!-- <div class="app-issue">
    <div class="vertical-center">
        <div class="text-center">
            <h1>You are using an outdated browser.</h1>
            <span>This web app is not compatible with following browser. Please upgrade your browser to improve your security and experience.</span>
        </div>
    </div>
</div> -->
<!-- <style> #app {
    display: none;
} </style> -->
<!-- <![endif] -->
<!-- NoScript -->
<noscript>
    <div class="app-issue">
        <div class="vertical-center">
            <div class="text-center">
                <h1>JavaScript is disabled in your browser.</h1>
                <span>Please enable JavaScript in your browser or upgrade to a JavaScript-capable browser to register for Groover.</span>
            </div>
        </div>
    </div>
    <style>
    #app {
        display: none;
    }
    </style>
</noscript>
<!-- Google Analytics: change UA-XXXXX-Y to be your site's ID. -->
<script>
window.ga = function() {
    ga.q.push(arguments)
};
ga.q = [];
ga.l = +new Date;
ga('create', 'UA-XXXXX-Y', 'auto');
ga('send', 'pageview')
</script>
<script src="https://www.google-analytics.com/analytics.js" async defer></script>
<!-- Modernizr-JS -->
<script type="text/javascript" src="js/vendor/modernizr-custom.min.js"></script>
<!-- NProgress -->
<script type="text/javascript" src="js/nprogress.min.js"></script>
<!-- jQuery -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- Bootstrap JS -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- Popper -->
<script type="text/javascript" src="js/popper.min.js"></script>
<!-- ScrollUp -->
<script type="text/javascript" src="js/jquery.scrollUp.min.js"></script>
<!-- Elevate Zoom -->
<script type="text/javascript" src="js/jquery.elevatezoom.min.js"></script>
<!-- jquery-ui-range-slider -->
<script type="text/javascript" src="js/jquery-ui.range-slider.min.js"></script>
<!-- jQuery Slim-Scroll -->
<script type="text/javascript" src="js/jquery.slimscroll.min.js"></script>
<!-- jQuery Resize-Select -->
<script type="text/javascript" src="js/jquery.resize-select.min.js"></script>
<!-- jQuery Custom Mega Menu -->
<script type="text/javascript" src="js/jquery.custom-megamenu.min.js"></script>
<!-- jQuery Countdown -->
<script type="text/javascript" src="js/jquery.custom-countdown.min.js"></script>
<!-- Owl Carousel -->
<script type="text/javascript" src="js/owl.carousel.min.js"></script>
<!-- Main -->
<script type="text/javascript" src="js/app.js"></script>
</body>
</html>