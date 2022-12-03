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
</head>

<body>

<!-- app -->
<div id="app">
    <!-- Header -->
    <c:import url="header.jsp"></c:import>
    <!-- Header /- -->
    <!-- Page Introduction Wrapper -->
    <div class="page-style-a">
        <div class="container">
            <div class="page-intro">
                <h2>Shop</h2>
                <ul class="bread-crumb">
                    <li class="has-separator">
                        <i class="ion ion-md-home"></i>
                        <a href="home.html">Home</a>
                    </li>
                    <li class="is-marked">
                        <a href="shop-v6-search-results.html">Shop</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!-- Page Introduction Wrapper /- -->
    <!-- Shop-Page -->
    <div class="page-shop u-s-p-t-80">
        <div class="container">
            <!-- Search-Results -->
            <div class="search-results-wrapper u-s-p-b-80">
                <h4>WE FOUND ${gameList.size()} RESULTS FOR
                    <i>${term}</i>
                </h4>
                <!-- <h4>Related searches:
                    <a href="shop-v1-root-category.html">men's clothing</a> ,
                    <a href="shop-v1-root-category.html">mobiles & tablets</a> ,
                    <a href="shop-v1-root-category.html">books & audible</a>
                </h4> -->
            </div>
            <!-- Search-Results /- -->
            <div class="row">
                <!-- Shop-Left-Side-Bar-Wrapper -->
                <!-- <div class="col-lg-3 col-md-3 col-sm-12"> -->
                    <!-- Fetch-Categories-from-Root-Category  -->
                    <!-- <div class="fetch-categories">
                        <h3 class="title-name">Browse Categories</h3>
                        <ul>
                            <li>
                                <a href="shop-v1-root-category.html">Men's Clothing</a>
                                <button class="button-icon ion ion-md-add js-open"></button>
                                <ul style="display: block">
                                    <li>
                                        <a href="shop-v2-sub-category.html">Tops</a>
                                        <button class="button-icon ion ion-md-add js-open"></button>
                                        <ul style="display: block">
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
                                                <a href="shop-v4-filter-as-category.html">Black Bean T-Shirt</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="shop-v2-sub-category.html">Outwear</a>
                                        <button class="button-icon ion ion-md-add"></button>
                                        <ul>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Jackets</a>
                                            </li>
                                            <li>
                                                <a href="shop-v2-sub-category.html">Trench</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Parkas</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Sweaters</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="shop-v2-sub-category.html">Accessories</a>
                                        <button class="button-icon ion ion-md-add"></button>
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
                                    <li>
                                        <a href="shop-v2-sub-category.html">Bottoms</a>
                                        <button class="button-icon ion ion-md-add"></button>
                                        <ul>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Casual Pants</a>
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
                                    <li>
                                        <a href="shop-v2-sub-category.html">Underwear</a>
                                        <button class="button-icon ion ion-md-add"></button>
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
                                    <li>
                                        <a href="shop-v2-sub-category.html">Sunglasses</a>
                                        <button class="button-icon ion ion-md-add"></button>
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
                            </li>
                            <li>
                                <a>Women's Clothing</a>
                                <button class="button-icon ion ion-md-add"></button>
                                <ul>
                                    <li>
                                        <a href="shop-v2-sub-category.html">Tops</a>
                                        <button class="button-icon ion ion-md-add"></button>
                                        <ul>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Dresses</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Blouses & Shirts</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">T-shirts</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Sweater</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="shop-v2-sub-category.html">Intimates</a>
                                        <button class="button-icon ion ion-md-add"></button>
                                        <ul>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Bras</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Brief Sets</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Bustiers & Corsets</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Panties</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="shop-v2-sub-category.html">Wedding & Events</a>
                                        <button class="button-icon ion ion-md-add"></button>
                                        <ul>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Wedding Dresses</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Evening Dresses</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Prom Dresses</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Flower Dresses</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="shop-v2-sub-category.html">Bottoms</a>
                                        <button class="button-icon ion ion-md-add"></button>
                                        <ul>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Skirts</a>
                                            </li>
                                            <li>
                                                <a href="shop-v2-sub-category.html">Shoes</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Leggings</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Jeans</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="shop-v2-sub-category.html">Outwear & Jackets</a>
                                        <button class="button-icon ion ion-md-add"></button>
                                        <ul>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Blazers</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Basics Jackets</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Trench</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Leather & Suede</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="shop-v2-sub-category.html">Accessories</a>
                                        <button class="button-icon ion ion-md-add"></button>
                                        <ul>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Sunglasses</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Headwear</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Baseball Caps</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Belts</a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="shop-v1-root-category.html">Toys Hobbies & Robots</a>
                                <button class="button-icon ion ion-md-add"></button>
                                <ul>
                                    <li>
                                        <a href="shop-v2-sub-category.html">RC Toys & Hobbies</a>
                                        <button class="button-icon ion ion-md-add"></button>
                                        <ul>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">RC Helicopter</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">RC Lego Robots</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">RC Drone</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">RC Car</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">RC Boat</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">RC Robot</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Multi Rotor Parts</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">FPV System</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Radios & Receiver</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Battery & Charger</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="shop-v2-sub-category.html">Solar Energy</a>
                                        <button class="button-icon ion ion-md-add"></button>
                                        <ul>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Solar Powered Toy</a>
                                            </li>
                                            <li>
                                                <a href="shop-v3-sub-sub-category.html">Solar Powered System</a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="shop-v1-root-category.html">Mobiles & Tablets</a>
                            </li>
                            <li>
                                <a href="shop-v1-root-category.html">Consumer Electronics</a>
                            </li>
                            <li>
                                <a href="shop-v1-root-category.html">Books & Audible</a>
                            </li>
                            <li>
                                <a href="shop-v1-root-category.html">Beauty & Health</a>
                            </li>
                            <li>
                                <a href="shop-v1-root-category.html">Furniture Home & Office</a>
                            </li>
                        </ul>
                    </div> -->
                    <!-- Fetch-Categories-from-Root-Category  /- -->
                    <!-- Filters -->
                    <!-- Filter-Price -->
                    <!-- <div class="facet-filter-by-price">
                        <h3 class="title-name">Price</h3>
                        <form class="facet-form" action="#" method="post"> -->
                            <!-- Final-Result -->
                            <!-- <div class="amount-result clearfix">
                                <div class="price-from">$0</div>
                                <div class="price-to">$3000</div>
                            </div> -->
                            <!-- Final-Result /- -->
                            <!-- Range-Slider  -->
                            <!-- <div class="price-filter"></div> -->
                            <!-- Range-Slider /- -->
                            <!-- Range-Manipulator -->
                            <!-- <div class="price-slider-range" data-min="0" data-max="5000" data-default-low="0" data-default-high="3000" data-currency="$"></div> -->
                            <!-- Range-Manipulator /- -->
                            <!-- <button type="submit" class="button button-primary">Filter</button>
                        </form>
                    </div> -->
                    <!-- Filter-Price /- -->
                    <!-- Filter-Free-Shipping -->
                    <!-- <div class="facet-filter-by-shipping">
                        <h3 class="title-name">Shipping</h3>
                        <form class="facet-form" action="#" method="post">
                            <input type="checkbox" class="check-box" id="cb-free-ship">
                            <label class="label-text" for="cb-free-ship">Free Shipping</label>
                        </form>
                    </div> -->
                    <!-- Filter-Free-Shipping /- -->
                    <!-- Filter-Rating -->
                    <!-- <div class="facet-filter-by-rating">
                        <h3 class="title-name">Rating</h3>
                        <div class="facet-form"> -->
                            <!-- 5 Stars -->
                            <!-- <div class="facet-link">
                                <div class="item-stars">
                                    <div class='star'>
                                        <span style='width:76px'></span>
                                    </div>
                                </div>
                                <span class="total-fetch-items">(0)</span>
                            </div> -->
                            <!-- 5 Stars /- -->
                            <!-- 4 & Up Stars -->
                            <!-- <div class="facet-link">
                                <div class="item-stars">
                                    <div class='star'>
                                        <span style='width:60px'></span>
                                    </div>
                                </div>
                                <span class="total-fetch-items">& Up (8)</span>
                            </div> -->
                            <!-- 4 & Up Stars /- -->
                            <!-- 3 & Up Stars -->
                            <!-- <div class="facet-link">
                                <div class="item-stars">
                                    <div class='star'>
                                        <span style='width:45px'></span>
                                    </div>
                                </div>
                                <span class="total-fetch-items">& Up (0)</span>
                            </div> -->
                            <!-- 3 & Up Stars /- -->
                            <!-- 2 & Up Stars -->
                            <!-- <div class="facet-link">
                                <div class="item-stars">
                                    <div class='star'>
                                        <span style='width:30px'></span>
                                    </div>
                                </div>
                                <span class="total-fetch-items">& Up (0)</span>
                            </div> -->
                            <!-- 2 & Up Stars /- -->
                            <!-- 1 & Up Stars -->
                           <!--  <div class="facet-link">
                                <div class="item-stars">
                                    <div class='star'>
                                        <span style='width:15px'></span>
                                    </div>
                                </div>
                                <span class="total-fetch-items">& Up (0)</span>
                            </div> -->
                            <!-- 1 & Up Stars /- -->
                        <!-- </div>
                    </div> -->
                    <!-- Filter-Rating -->
                    <!-- Filters /- -->
                <!-- </div> -->
                <!-- Shop-Left-Side-Bar-Wrapper /- -->
                <!-- Shop-Right-Wrapper -->
                <div class="col-lg-9 col-md-9 col-sm-12">
                    <!-- Page-Bar -->
                    <div class="page-bar clearfix">
                        <div class="shop-settings">
                            <a id="list-anchor" class="active">
                                <i class="fas fa-th-list"></i>
                            </a>
                            <a id="grid-anchor">
                                <i class="fas fa-th"></i>
                            </a>
                        </div>
                        <!-- Toolbar Sorter 1  -->
                        <!-- <div class="toolbar-sorter">
                            <div class="select-box-wrapper">
                                <label class="sr-only" for="sort-by">Sort By</label>
                                <select class="select-box" id="sort-by" name="sort-by">
                                    <option selected="selected" value="alphabetic">Sort By: Alphabetic</option>
                                    <option value="lowest">Sort By: Lowest Price</option>
                                    <option value="highest">Sort By: Highest Price</option>
                                </select>
                            </div>
                        </div> -->
                        <!-- //end Toolbar Sorter 1  -->
                        <!-- Toolbar Sorter 2  -->
<!--                         <div class="toolbar-sorter-2">
                            <div class="select-box-wrapper">
                                <label class="sr-only" for="show-records">Show Records Per Page</label>
                                <select class="select-box" id="show-records" name="show-records">
                                    <option selected="selected" value="8">Show: 8</option>
                                    <option value="16">Show: 16</option>
                                    <option value="28">Show: 28</option>
                                </select>
                            </div>
                        </div> -->
                        <!-- //end Toolbar Sorter 2  -->
                    </div>
                    <!-- Page-Bar /- -->
                    <!-- Row-of-Product-Container -->
                    <div class="row product-container list-style">
                        <div class="product-item col-lg-4 col-md-6 col-sm-6">
                            <c:forEach var="i" begin="${(index-1)*12}" end="${(index)*12}">
                                <c:if test = "${i < gameList.size()}">
                                    <c:set var = "game" value = "${gameList.get(i)}"/>
                                    <div class="item">
                                        <div class="image-container">
                                            <a class="item-img-wrapper-link" href="game?id=${game.getID()}">
                                                <img class="img-fluid" src="${game.getImages().get(0)}" alt="Product">
                                            </a>
                                            <div class="item-action-behaviors">
                                                <a class="item-addwishlist" href="javascript:void(0)">Add to Wishlist</a>
                                                <a class="item-addCart" href="javascript:void(0)">Add to Cart</a>
                                            </div>
                                        </div>
                                        <div class="item-content">
                                            <div class="what-product-is">
                                                <ul class="bread-crumb">
                                                    <!-- <c:forEach var="genre_single" items="${game.getGenres()}">
                                                                    <li class="has-separator">
                                                                        <a href="shop-v1-root-category.html">${genre_single.getDescription()}</a>
                                                                    </li>
                                                    </c:forEach> -->
                                                </ul>
                                                <h6 class="item-title">
                                                    <a href="game?id=${game.getID()}">${game.getName()}</a>
                                                </h6>
                                                <div class="item-description">
                                                    <p>${game.getDesc()}
                                                    </p>
                                                </div>
                                                <div class="item-stars">
                                                    <div class='star' title="${game.getRating()} out of 5 - based on 0 Reviews">
                                                        <span style='width:0'></span>
                                                    </div>
                                                </div>
                                                
                                            </div>
                                            <div class="price-template">
                                                <c:if test="${not game.getIsFree()}">
                                                    <div class="item-new-price">
                                                        ${game.getInitialPrice()} USD
                                                    </div>
                                                </c:if> 
                                                <c:if test="${game.getIsFree()}">
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
                                        <!-- <div class="tag new">
                                            <span>NEW</span>
                                        </div> -->
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                    <!-- Row-of-Product-Container /- -->
                </div>
                <!-- Shop-Right-Wrapper /- -->
                <!-- Shop-Pagination -->
                <div class="pagination-area">
                    <div class="pagination-number">
                        <ul display:inline>
                            <c:choose>
                                <c:when test="${index==1}">
                                    <li style="display: none">
                                </c:when>    
                                <c:otherwise>
                                    <li>
                                </c:otherwise>
                            </c:choose>
                                <a href="search?term=${term}&index=${index-1}" title="Previous">
                                    <i class="fa fa-angle-left"></i>
                                </a>
                            </li>
                            <c:choose>
                                <c:when test="${index > (gameList.size()%12+1) }">
                                    <li style="display: none">
                                </c:when>    
                                <c:otherwise>
                                    <li>
                                </c:otherwise>
                            </c:choose>
                                <a href="search?term=${term}&index=${index+1}" title="Next">
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- Shop-Pagination /- -->
            </div>
        </div>
    </div>
    <!-- Shop-Page /- -->
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
                    <a href="home.html">Groover</a> All Right Reserved
                </p>
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
                                    <h6 class="information-heading u-s-m-b-8">Description:</h6>
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
                                <div class="section-4-sku-information u-s-p-y-14">
                                    <h6 class="information-heading u-s-m-b-8">Sku Information:</h6>
                                    <div class="availability">
                                        <span>Availability:</span>
                                        <span>In Stock</span>
                                    </div>
                                    <div class="left">
                                        <span>Only:</span>
                                        <span>50 left</span>
                                    </div>
                                </div>
                                <div class="section-5-product-variants u-s-p-y-14">
                                    <h6 class="information-heading u-s-m-b-8">Product Variants:</h6>
                                    <div class="color u-s-m-b-11">
                                        <span>Available Color:</span>
                                        <div class="color-variant select-box-wrapper">
                                            <select class="select-box product-color">
                                                <option value="1">Heather Grey</option>
                                                <option value="3">Black</option>
                                                <option value="5">White</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="sizes u-s-m-b-11">
                                        <span>Available Size:</span>
                                        <div class="size-variant select-box-wrapper">
                                            <select class="select-box product-size">
                                                <option value="">Male 2XL</option>
                                                <option value="">Male 3XL</option>
                                                <option value="">Kids 4</option>
                                                <option value="">Kids 6</option>
                                                <option value="">Kids 8</option>
                                                <option value="">Kids 10</option>
                                                <option value="">Kids 12</option>
                                                <option value="">Female Small</option>
                                                <option value="">Male Small</option>
                                                <option value="">Female Medium</option>
                                                <option value="">Male Medium</option>
                                                <option value="">Female Large</option>
                                                <option value="">Male Large</option>
                                                <option value="">Female XL</option>
                                                <option value="">Male XL</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="section-6-social-media-quantity-actions u-s-p-y-14">
                                    <form action="#" class="post-form">
                                        <div class="quick-social-media-wrapper u-s-m-b-22">
                                            <span>Share:</span>
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
                                            </ul>
                                        </div>
                                        <div class="quantity-wrapper u-s-m-b-22">
                                            <span>Quantity:</span>
                                            <div class="quantity">
                                                <input type="text" class="quantity-text-field" value="1">
                                                <a class="plus-a" data-max="1000">&#43;</a>
                                                <a class="minus-a" data-min="1">&#45;</a>
                                            </div>
                                        </div>
                                        <div>
                                            <button class="button button-outline-secondary" type="submit">Add to cart</button>
                                            <button class="button button-outline-secondary far fa-heart u-s-m-l-6"></button>
                                            <button class="button button-outline-secondary far fa-envelope u-s-m-l-6"></button>
                                        </div>
                                    </form>
                                </div>
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
<!--[if lte IE 9]>
<div class="app-issue">
    <div class="vertical-center">
        <div class="text-center">
            <h1>You are using an outdated browser.</h1>
            <span>This web app is not compatible with following browser. Please upgrade your browser to improve your security and experience.</span>
        </div>
    </div>
</div>
<style> #app {
    display: none;
} </style>
<![endif]-->
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
