<!DOCTYPE html>
<html lang="en" class="js">
<head>
    <meta charset="utf-8">
    <title>Profile settings</title>
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
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
  <div class="app">
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
                          <a>My Account
                              <i class="fas fa-chevron-down u-s-m-l-9"></i>
                          </a>
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
                                      <!-- Replace with logout button if user is already logged in -->
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
                                      <i class="ion ion-md-home u-c-brand"></i>
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
    </header>
  <!-- Header /- -->
    <div class="container">
  
          <!-- Breadcrumb -->
          <nav aria-label="breadcrumb" class="main-breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="home.html">Home</a></li>
              <li class="breadcrumb-item"><a href="javascript:void(0)">User</a></li>
              <li class="breadcrumb-item active" aria-current="page">Profile Settings</li>
            </ol>
          </nav>
          <!-- /Breadcrumb -->
  
          <div class="row gutters-sm">
            <div class="col-md-4 d-none d-md-block">
              <div class="card">
                <div class="card-body">
                  <nav class="nav flex-column nav-pills nav-gap-y-1">
                    <a href="#profile" data-toggle="tab" class="nav-item nav-link has-icon nav-link-faded active">
                      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-user mr-2"><path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path><circle cx="12" cy="7" r="4"></circle></svg>Profile Information
                    </a>
                    <a href="#account" data-toggle="tab" class="nav-item nav-link has-icon nav-link-faded">
                      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-settings mr-2"><circle cx="12" cy="12" r="3"></circle><path d="M19.4 15a1.65 1.65 0 0 0 .33 1.82l.06.06a2 2 0 0 1 0 2.83 2 2 0 0 1-2.83 0l-.06-.06a1.65 1.65 0 0 0-1.82-.33 1.65 1.65 0 0 0-1 1.51V21a2 2 0 0 1-2 2 2 2 0 0 1-2-2v-.09A1.65 1.65 0 0 0 9 19.4a1.65 1.65 0 0 0-1.82.33l-.06.06a2 2 0 0 1-2.83 0 2 2 0 0 1 0-2.83l.06-.06a1.65 1.65 0 0 0 .33-1.82 1.65 1.65 0 0 0-1.51-1H3a2 2 0 0 1-2-2 2 2 0 0 1 2-2h.09A1.65 1.65 0 0 0 4.6 9a1.65 1.65 0 0 0-.33-1.82l-.06-.06a2 2 0 0 1 0-2.83 2 2 0 0 1 2.83 0l.06.06a1.65 1.65 0 0 0 1.82.33H9a1.65 1.65 0 0 0 1-1.51V3a2 2 0 0 1 2-2 2 2 0 0 1 2 2v.09a1.65 1.65 0 0 0 1 1.51 1.65 1.65 0 0 0 1.82-.33l.06-.06a2 2 0 0 1 2.83 0 2 2 0 0 1 0 2.83l-.06.06a1.65 1.65 0 0 0-.33 1.82V9a1.65 1.65 0 0 0 1.51 1H21a2 2 0 0 1 2 2 2 2 0 0 1-2 2h-.09a1.65 1.65 0 0 0-1.51 1z"></path></svg>Account Settings
                    </a>
                    <a href="#security" data-toggle="tab" class="nav-item nav-link has-icon nav-link-faded">
                      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shield mr-2"><path d="M12 22s8-4 8-10V5l-8-3-8 3v7c0 6 8 10 8 10z"></path></svg>Security
                    </a>
                    <a href="#notification" data-toggle="tab" class="nav-item nav-link has-icon nav-link-faded">
                      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-bell mr-2"><path d="M18 8A6 6 0 0 0 6 8c0 7-3 9-3 9h18s-3-2-3-9"></path><path d="M13.73 21a2 2 0 0 1-3.46 0"></path></svg>Notification
                    </a>
                    <a href="#billing" data-toggle="tab" class="nav-item nav-link has-icon nav-link-faded">
                      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-credit-card mr-2"><rect x="1" y="4" width="22" height="16" rx="2" ry="2"></rect><line x1="1" y1="10" x2="23" y2="10"></line></svg>Billing
                    </a>
                  </nav>
                </div>
              </div>
            </div>
            <div class="col-md-8">
              <div class="card">
                <div class="card-header border-bottom mb-3 d-flex d-md-none">
                  <ul class="nav nav-tabs card-header-tabs nav-gap-x-1" role="tablist">
                    <li class="nav-item">
                      <a href="#profile" data-toggle="tab" class="nav-link has-icon active"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-user"><path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path><circle cx="12" cy="7" r="4"></circle></svg></a>
                    </li>
                    <li class="nav-item">
                      <a href="#account" data-toggle="tab" class="nav-link has-icon"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-settings"><circle cx="12" cy="12" r="3"></circle><path d="M19.4 15a1.65 1.65 0 0 0 .33 1.82l.06.06a2 2 0 0 1 0 2.83 2 2 0 0 1-2.83 0l-.06-.06a1.65 1.65 0 0 0-1.82-.33 1.65 1.65 0 0 0-1 1.51V21a2 2 0 0 1-2 2 2 2 0 0 1-2-2v-.09A1.65 1.65 0 0 0 9 19.4a1.65 1.65 0 0 0-1.82.33l-.06.06a2 2 0 0 1-2.83 0 2 2 0 0 1 0-2.83l.06-.06a1.65 1.65 0 0 0 .33-1.82 1.65 1.65 0 0 0-1.51-1H3a2 2 0 0 1-2-2 2 2 0 0 1 2-2h.09A1.65 1.65 0 0 0 4.6 9a1.65 1.65 0 0 0-.33-1.82l-.06-.06a2 2 0 0 1 0-2.83 2 2 0 0 1 2.83 0l.06.06a1.65 1.65 0 0 0 1.82.33H9a1.65 1.65 0 0 0 1-1.51V3a2 2 0 0 1 2-2 2 2 0 0 1 2 2v.09a1.65 1.65 0 0 0 1 1.51 1.65 1.65 0 0 0 1.82-.33l.06-.06a2 2 0 0 1 2.83 0 2 2 0 0 1 0 2.83l-.06.06a1.65 1.65 0 0 0-.33 1.82V9a1.65 1.65 0 0 0 1.51 1H21a2 2 0 0 1 2 2 2 2 0 0 1-2 2h-.09a1.65 1.65 0 0 0-1.51 1z"></path></svg></a>
                    </li>
                    <li class="nav-item">
                      <a href="#security" data-toggle="tab" class="nav-link has-icon"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shield"><path d="M12 22s8-4 8-10V5l-8-3-8 3v7c0 6 8 10 8 10z"></path></svg></a>
                    </li>
                    <li class="nav-item">
                      <a href="#notification" data-toggle="tab" class="nav-link has-icon"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-bell"><path d="M18 8A6 6 0 0 0 6 8c0 7-3 9-3 9h18s-3-2-3-9"></path><path d="M13.73 21a2 2 0 0 1-3.46 0"></path></svg></a>
                    </li>
                    <li class="nav-item">
                      <a href="#billing" data-toggle="tab" class="nav-link has-icon"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-credit-card"><rect x="1" y="4" width="22" height="16" rx="2" ry="2"></rect><line x1="1" y1="10" x2="23" y2="10"></line></svg></a>
                    </li>
                  </ul>
                </div>
                <div class="card-body tab-content">
                  <div class="tab-pane active" id="profile">
                    <h6>YOUR PROFILE INFORMATION</h6>
                    <hr>
                      <form action="profile" method="post" id="profileInformation">
                        <input type="hidden" name="action" value="updateProfile">
                      <div class="form-group">
                        <label for="fullName">Full Name</label>
                        <input type="text" class="form-control" id="fullName" name="fullName" aria-describedby="fullNameHelp" placeholder="Enter your fullname" value="Kenneth Valdez">
                        <small id="fullNameHelp" class="form-text text-muted">Your name may appear around here where you are mentioned. You can change or remove it at any time.</small>
                      </div>
                      <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" id="username" name="username" aria-describedby="usernameHelp" value="KennethValdez" disabled>
                      </div>
                      <div class="form-group">
                        <label for="bio">Your Bio</label>
                        <textarea class="form-control autosize" id="bio" name="bio" placeholder="Write something about you" style="overflow: hidden; overflow-wrap: break-word; resize: none; height: 62px;">A weeb.</textarea>
                      </div>
                      <div class="form-group">
                        <label for="url">URL</label>
                        <input type="text" class="form-control" id="url" name="url" placeholder="Enter your website address" value="http://benije.ke/pozzivkij">
                      </div>
                      <div class="form-group">
                        <label for="location">Location</label>
                        <input type="text" class="form-control" id="location" name="location" placeholder="Enter your location" value="Bay Area, San Francisco, CA">
                      </div>
                      <div class="form-group small text-muted">
                        All of the fields on this page are optional and can be deleted at any time, and by filling them out, you're giving us consent to share this data wherever your user profile appears.
                      </div>
                      <!-- <button type="button" class="btn btn-primary" id="updateProfileToast">Update Profile</button> -->
                      <button type="submit" class="btn btn-primary" id="updateProfileToast">Update Profile</button>
                      <button type="reset" class="btn btn-light">Reset Changes</button>
                      
                    </form>
                  </div>
                  <div class="tab-pane" id="account">
                    <h6>ACCOUNT SETTINGS</h6>
                    <hr>
                    <form>
                      <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" id="username" aria-describedby="usernameHelp" placeholder="Enter your username" value="kennethvaldez">
                        <small id="usernameHelp" class="form-text text-muted">After changing your username, your old username becomes available for anyone else to claim.</small>
                      </div>
                      <hr>
                      <div class="form-group">
                        <label class="d-block text-danger">Delete Account</label>
                        <p class="font-size-sm warning text-danger">Once you delete your account, there is no going back. Please be certain.</p>
                      </div>
                      <button class="btn btn-danger" type="button">Delete Account</button>
                    </form>
                  </div>
                  <div class="tab-pane" id="security">
                    <h6>SECURITY SETTINGS</h6>
                    <hr>
                    <form>
                      <div class="form-group">
                        <label class="d-block">Change Password</label>
                        <input type="text" class="form-control" placeholder="Enter your old password" id="oldPassword">
                        <input type="text" class="form-control mt-1" placeholder="New password" id="newPassword">
                        <input type="text" class="form-control mt-1" placeholder="Confirm new password" id="rnewPassword">
                      </div>
                    </form>
                    <hr>
                    <form>
                      <div class="form-group">
                        <label class="d-block">Two Factor Authentication</label>
                        <button class="btn btn-info" type="button">Enable two-factor authentication</button>
                        <p class="small text-muted mt-2">Two-factor authentication adds an additional layer of security to your account by requiring more than just a password to log in.</p>
                      </div>
                    </form>
                    <hr>
                    <form>
                      <div class="form-group mb-0">
                        <label class="d-block">Sessions</label>
                        <p class="font-size-sm text-secondary">This is a list of devices that have logged into your account. Revoke any sessions that you do not recognize.</p>
                        <ul class="list-group list-group-sm">
                          <li class="list-group-item has-icon">
                            <div>
                              <h6 class="mb-0">San Francisco City 190.24.335.55</h6>
                              <small class="text-muted">Your current session seen in United States</small>
                            </div>
                            <button class="btn btn-light btn-sm ml-auto" type="button">More info</button>
                          </li>
                        </ul>
                      </div>
                    </form>
                  </div>
                  <div class="tab-pane" id="notification">
                    <h6>NOTIFICATION SETTINGS</h6>
                    <hr>
                    <form>
                      <div class="form-group">
                        <label class="d-block mb-0">Security Alerts</label>
                        <div class="small text-muted mb-3">Receive security alert notifications via email</div>
                        <div class="custom-control custom-checkbox">
                          <input type="checkbox" class="custom-control-input" id="customCheck1" checked="">
                          <label class="custom-control-label" for="customCheck1">Email each time a vulnerability is found</label>
                        </div>
                        <div class="custom-control custom-checkbox">
                          <input type="checkbox" class="custom-control-input" id="customCheck2" checked="">
                          <label class="custom-control-label" for="customCheck2">Email a digest summary of vulnerability</label>
                        </div>
                      </div>
                      <div class="form-group mb-0">
                        <label class="d-block">SMS Notifications</label>
                        <ul class="list-group list-group-sm">
                          <li class="list-group-item has-icon">
                            Comments
                            <div class="custom-control custom-control-nolabel custom-switch ml-auto">
                              <input type="checkbox" class="custom-control-input" id="customSwitch1" checked="">
                              <label class="custom-control-label" for="customSwitch1"></label>
                            </div>
                          </li>
                          <li class="list-group-item has-icon">
                            Updates From People
                            <div class="custom-control custom-control-nolabel custom-switch ml-auto">
                              <input type="checkbox" class="custom-control-input" id="customSwitch2">
                              <label class="custom-control-label" for="customSwitch2"></label>
                            </div>
                          </li>
                          <li class="list-group-item has-icon">
                            Reminders
                            <div class="custom-control custom-control-nolabel custom-switch ml-auto">
                              <input type="checkbox" class="custom-control-input" id="customSwitch3" checked="">
                              <label class="custom-control-label" for="customSwitch3"></label>
                            </div>
                          </li>
                          <li class="list-group-item has-icon">
                            Events
                            <div class="custom-control custom-control-nolabel custom-switch ml-auto">
                              <input type="checkbox" class="custom-control-input" id="customSwitch4" checked="">
                              <label class="custom-control-label" for="customSwitch4"></label>
                            </div>
                          </li>
                          <li class="list-group-item has-icon">
                            Pages You Follow
                            <div class="custom-control custom-control-nolabel custom-switch ml-auto">
                              <input type="checkbox" class="custom-control-input" id="customSwitch5">
                              <label class="custom-control-label" for="customSwitch5"></label>
                            </div>
                          </li>
                        </ul>
                      </div>
                    </form>
                  </div>
                  <div class="tab-pane" id="billing">
                    <h6>BILLING SETTINGS</h6>
                    <hr>
                    <form>
                      <div class="form-group">
                        <label class="d-block mb-0">Payment Method</label>
                        <div class="small text-muted mb-3">You have not added a payment method</div>
                        <button class="btn btn-info" type="button">Add Payment Method</button>
                      </div>
                      <div class="form-group mb-0">
                        <label class="d-block">Payment History</label>
                        <div class="border border-gray-500 bg-gray-200 p-3 text-center font-size-sm">You have not made any payment.</div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
    </div>
  
    <style type="text/css">
        body{
            /* margin-top:20px; */
            /* color: #1a202c; */
            color: #bcd0f7;
            text-align: left;
            /* background-color: #e2e8f0;     */
            background-color: #1A233A;    
        }
        .main-body {
            padding: 15px;
        }
  
        .nav-link {
            /* color: #4a5568; */
            color: #bcd0f7;
        }
  
  
        ol.breadcrumb {
          background-color: #272E48;
          /* background-color: #CECAC3; */
        }
          ol.breadcrumb li a {
            color: #CECAC3;
          }
          .breadcrumb a:hover {
            color: #d90429; }
        /* .breadcrumb {
          list-style: none;
          word-wrap: break-word; }
          .breadcrumb a {
            color: #CECAC3; } */
        .card {
            box-shadow: 0 1px 3px 0 rgba(0,0,0,.1), 0 1px 2px 0 rgba(0,0,0,.06);
        }
  
        .card {
            position: relative;
            display: flex;
            flex-direction: column;
            min-width: 0;
            word-wrap: break-word;
            color: #bcd0f7;
            /* background-color: #fff; */
            background-color: #272E48;
            background-clip: border-box;
            border: 0 solid rgba(0,0,0,.125);
            border-radius: .25rem;
        }
  
        .card-body {
            flex: 1 1 auto;
            min-height: 1px;
            padding: 1rem;
        }
  
        .warning {
            /* bold text */
            /* color: #ff2600 !important; */
            font-weight: 500;
        }
  
        .gutters-sm {
            margin-right: -8px;
            margin-left: -8px;
        }
  
        .gutters-sm>.col, .gutters-sm>[class*=col-] {
            padding-right: 8px;
            padding-left: 8px;
        }
        .mb-3, .my-3 {
            margin-bottom: 1rem!important;
        }
  
        .bg-gray-300 {
            background-color: #e2e8f0;
        }
        .h-100 {
            height: 100%!important;
        }
        .shadow-none {
            box-shadow: none!important;
        }
  
        .list-group-item {
          background-color: #1A233A;
        }
  
        input[type=text], textarea#bio {
          background-color: #1A233A;
          color: white;
        }
  
        .successToast#update {
          position: fixed;
          
          /* opacity: 0.7; */
          /* z-index higher than any other elements (9999 should be enough) */
          z-index: 9999;
          /* toast stick to the bottom right but still have to fully shown */
          bottom: 1rem;
          right: 0.25rem;
        }
        .toast, .toast-header {
          background-color: #00a708;
          /* text color black */
          color: white;
          /* width: fit-content; */
          /* color: #00a708; */
          /* border-radius: 0.25rem; */
        }
        .toast-body {
          background-color: #07ba10;
          /* border-radius: 0.25rem; */
        }
        input:disabled {
          /* background-color: #CECAC3; */
          /* background-color: #DDDDDD; */
          background: #DDDDDD;
          color: #363030;
        }

    </style>
    <script>
    
      // var newMessage = $('<divclass="successToast"id="update"><divclass="toastfadehide"role="alert"data-delay="3000"data-autohide="false"><divclass="toast-header"><strongclass="mr-autotoast-header">Notification</strong><smallstyle="color:white">Justnow</small><buttontype="button"class="ml-2mb-1close"data-dismiss="toast"aria-label="Close"><spanaria-hidden="true">×</span></button></div><divclass="toast-body">Successfullyupdateprofile.</div></div></div>');
      $(document).ready(function() {
        $('#updateProfileToast').click( function (){
          $('.toast').toast('show');
        });
      });
      $("#profile").submit(function(e) {
          // e.preventDefault();
          // var http = new XMLHttpRequest();
          // http.open("POST", "/myaccount", true);
          // http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
          let userinfo = $("#profileInformation").serializeArray();
          let user = {};
          userinfo.forEach((value) => {
                  // Dynamically create an object
                  user[value.name] = value.value;
                  // user[value.id] = value.value;
          });
          console.log("user", user);
          user["action"] = "updateProfile";
          $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/myaccount",
            data: user,
            success: function(data) {
              console.log(data);
              // alert("Successfully update profile.");
              // $('#updateProfileToast').click();
              // $('.toast').toast('show');
            },
            error: function(data) {
              console.log(data);
              alert("Error");
            }
          });
          return false;
      });

    </script>
    <div class="successToast" id="update">
      <div class="toast fade hide" role="alert" data-delay="1500" data-autohide="true">
        <div class="toast-header">
            <!-- <strong class="mr-auto toast-header">Notification</strong> -->
            <strong class="mr-auto toast-header">Notification</strong>
            <small style="color: white">Just now</small>
            <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
        </div>
        <div class="toast-body"> Successfully update profile.</div>
      </div>
    </div>
    <!-- Footer -->
    <footer class="footer">
      <div class="container">
          <!-- Mid-Footer -->
          <!-- <div class="mid-footer-wrapper u-s-p-b-80"> -->
          <div class="mid-footer-wrapper u-s-p-y-60">
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
  </div>

</body>
</html>