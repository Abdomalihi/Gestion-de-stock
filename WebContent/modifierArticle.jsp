<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Modifier Article</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
    <style>
      .Menuu ul li{
        margin-top: 20px;

      }
   
    </style>
    
   
</head>
<body class="modal-open">
  <div style="background-color:#1a1a00; height: 100VH; ">
      <header  style="background-color: #1a1a00" >
          <div class="container-fluid">
              <div class="row" style="padding-top: 10px">
                <div class="col-md-4">
                    <a  href="#"><img src="img/gestion-stock.png" alt="" height="50" width="50"></a> 
                </div>
                <div class="col-md-8 ">
                    <div class="dropdown float-right" style="padding-right: 20px">
                        <a href="#" class="dropdown-toggle  nav-link " data-toggle="dropdown" style="color: whitesmoke">
                          <img src="img/gestion-stock.png" class="rounded-circle z-depth-0" alt="avatar image" height="30">
                           <span >Profile</span>
                            
                        </a>
                        <div class="dropdown-menu" >
                          <a class="dropdown-item" href="#">Mon Compte</a>
                          <a class="dropdown-item" href="#">Déconnecter</a>
                        </div>
                      </div> 
                </div>
              </div>
          </div>
            
        </header>
        <div class="container-fluid">
          <div class="row FULL">
            <div class="col-md-2 Menuu"  style="padding-left: 3px; background-color: #1a1a00">
                <ul class="nav flex-column float-left" style="margin: 20px">
                    <li class="nav-item">
                      <a class="nav-link active" href="/dashboard.html" style="color:whitesmoke"><i class="fas fa-chart-line glyphicon-align-left"></i> Dashboard</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="/article-index.html" style="color:whitesmoke"><i class="fas fa-warehouse "></i> Stock</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="/commande-index.html" style="color:whitesmoke"><i class="fas fa-list-ol glyphicon-align-left"></i> Commande</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="/livraison-index.html" style="color:whitesmoke"><i class="fas fa-truck-loading glyphicon-align-left"></i> Livraison</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="/client-index.html" style="color:whitesmoke"><i class="fas fa-user-friends glyphicon-align-left"></i> Client</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="/fournisseur-index.html" style="color:whitesmoke"><i class="fas fa-truck-loading glyphicon-align-left"></i> Fournisseur</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="/gestionnaire-index.html" style="color:whitesmoke"><i class="fas fa-users glyphicon-align-left"></i> Utilisateur</a>
                    </li>
                  </ul>
            </div>
            <div class="col-md-10 " style="padding: 10px; margin-top: 20px;height: calc(100vh - 160px)">
              <div class="container-fluid " style="height: 100%" >
                    
                  <div class="row bg-light" style="padding: 10px 30px 0px 30px">
                    <div class="col-md-12">
                        <p class="text-left" style="text-align:justify"><h3 style="margin: 10px"> Modifier Article</h3>  </p>
                    </div>
                  </div>
                  <div class="row bg-light" >
                    <div class="container">
                        <div>
							<form action="update-gestionnaire.html" method="POST" >
								
								<input type="hidden" value='${ param["idarticle"] }' name="iduser">
					            	<div class="form-row">
										    <div class="form-group col-md-6">
										      <label for="inputEmail4">Nom Article :</label>
										      <input type="email" class="form-control" id="inputEmail4" name="nomarticle" placeholder="nom" value="${artic.nomarticle }">
										    </div>
										    <div class="form-group col-md-6">
										      <label for="inputPassword4">Désignation :</label>
										      <input type="password" class="form-control" id="inputPassword4" name="designation" placeholder="designation" value="${article.designation }">
										    </div>
									</div>
									<div class="form-group">
										    <label for="inputAddress">Quantité en stock :</label>
										    <input type="text" class="form-control" id="inputAddress" name="qttestock" placeholder="quantité" value="${article.qttestock }">
					  				</div>
								
				                <div class="form-group">
				                     
          							 <input type="submit" class="btn btn-secondary" value="Enregistrer"> 
				                </div>
				               
							</form>
								</div>
								
                        </div>
                    </div>                    
                  </div>
              </div>                
            </div>
          </div>    
        </div>
        <footer class="text-center fixed-bottom " >
    
          
          <div class="col-md-12 footer-copyright text-center py-3"><span style="color: whitesmoke">© 2019 Copyright:</span> 
            <a href="http://www.iga.ac.ma/" style="color: whitesmoke"> www.iga.ac.ma</a>
          </div>
          
        
        </footer> 
  </div>

  
  
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>