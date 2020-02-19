<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
    <style>
      .Menuu ul li{
        margin-top: 20px;

      }
   
    </style>
</head>
<body>
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
                      <a class="nav-link" href="/fournisseur.html" style="color:whitesmoke"><i class="fas fa-truck-loading glyphicon-align-left"></i> Fournisseur</a>
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
                        <p class="text-left" style="text-align:justify"><h3 style="margin: 10px">Fournisseur</h3>  </p>
                    </div>
                      <div class="col-md-6">
                          <ul class="nav ">
                              <li class="nav-item">
                                <button type="button" class="nav-link btn btn-outline-secondary "  data-toggle="modal" data-target="#ajouter">Ajouter</button>
                              </li>
                            </ul>
                      </div>
                      <div class="col-md-6">
                          <form class="form-inline my-2 my-lg-0 float-right" action="chercher.html" method="get">
                              <input class="form-control mr-sm-2 float-right" type="search" name="motcle" aria-label="Search">
                              <button class="btn btn-outline-secondary my-2 my-sm-0 float-right" type="submit">Chercher</button>
                            </form>
                      </div>
                          <br>
                          <br>
                      
                  </div>
                  <div class="row bg-light" style="height: calc(100% - 20px - 60px)">
                    <div class="container">
                        <div class="table " >
                            <table class="table table-striped" style="padding-left: 5px">
                                
                                  <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Nom</th>
                                    <th scope="col">Prenom</th>
                                    <th scope="col">Adresse</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Télephone</th>
                                    <th scope="col">Action</th>
                                  </tr>
                                  <c:forEach items="${model.fournisseurs}" var="c">
	                                  <tr>
	                                    <td scope="row">${f.idfour}</td>
	                                    <td>${f.nomfour}</td>
	                                    <td>${f.prenomfour}</td>
	                                    <td>${f.adressefour}</td>
	                                    <td>${f.emailfour}</td>
	                                    <td>${f.telfour}</td>
	                                    <td>
	                                    	<div class="dropdown">
												  <button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown">
												    Edit/Delete
												  </button>
												  <div class="dropdown-menu">
												    <a class="dropdown-item" href="modifier.html?idfour=${f.idfour}">Modifier</a>
												    <a class="dropdown-item" href="supprimer.html?idfour=${f.idfour}">Supprimer</a>
												  </div>
											</div>
										</td>
	                                  </tr>                                  	
                                  </c:forEach>                                
                              </table>
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

  
  <!-- Modal -->
  <div class="modal fade" id="ajouter" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <form action="ajouterFournisseur.html" method="post">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel" style="text-align: center">Ajouter Fournisseur </h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
            
                <div class="form-group">
                  <label for="formGroupExampleInput">Nom :</label>
                  <input type="text" class="form-control" id="formGroupExampleInput" name="nomfour" placeholder="nom">
                </div>
                <div class="form-group">
                  <label for="formGroupExampleInput2">Prénom :</label>
                  <input type="text" class="form-control" id="formGroupExampleInput2" name="prenomfour" placeholder="prénom">
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput">Adresse :</label>
                    <input type="text" class="form-control" id="formGroupExampleInput" name="adressefour" placeholder="adresse">
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Email :</label>
                    <input type="text" class="form-control" id="formGroupExampleInput2" name="emailfour" placeholder="exemple@exemple.com">
                </div>
                <div class="form-group">
                      <label for="formGroupExampleInput2">Télephone :</label>
                      <input type="text" class="form-control" id="formGroupExampleInput2" name="telfour" placeholder="+212xxxxxxxxx">
                </div>
              
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <input type="submit" class="btn btn-secondary"  value="Enregistrer">
        </div>
      </div>
      </form>
    </div>
  </div>
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>