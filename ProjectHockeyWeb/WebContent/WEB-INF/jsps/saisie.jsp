
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="ejbHockey.Gardien" %>
<%@ page import="ejbHockey.Match" %>

<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->


    
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
         <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
         <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet"/>
        <script src="${pageContext.request.contextPath}/js/vendor/jquery-1.11.2.js"></script>
        <script src="${pageContext.request.contextPath}/js/vendor/bootstrap.min.js"></script>
     
        
    </head>
    <body>
   
		
	<!--###DOCUMENT###start-->    
    <nav class="navbar navbar-default">
        <div class="container">
 
                <div class="navbar-header ">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navigation" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>   
                </div>

               <ul class="nav navbar-nav collapse navbar-collapse" id="navigation">
                   <li><a href="#">Accueil</a></li>
                   <li><a href="http://localhost:8080/ProjectHockeyWeb/LogoutExecuteServlet">Deconnexion</a></li>
               </ul>
            <div class="line"></div>
        </div>
               
    	<div id="choice_match">
    		<%
						Iterator it = ((Collection)request.getAttribute("listMatchs")).iterator();
						while(it.hasNext()) {
						Match match = (Match)it.next();
			%>
						<label><%= match.getNom() %></label>
						<input type="radio" name="match" value="<%= match.getId() %>">					
			<%
				}
			%> 
    	</div>
   	</nav>
        <div class="container" id="presentation">
            <div class="titre"><span>D&eacute;clarer un tir</span></div>
            <div class="line2"></div>
            <div class="row" id="workflow">
                <div class="workflow-tir" data-page="1">
                    <div class="div-patinoire">
                        <div class="zone-attaque"></div>
                        <div class="zone-neutre"></div>
                        <div class="zone-defense">
                            <div class="zone-tir" id="zone-tir-1" data-id="1" data-label="ZONE 1">
                                <span>ZONE 1</span>
                            </div>
                            <div class="zone-tir" id="zone-tir-2" data-id="2" data-label="ZONE 2">
                                <span>ZONE 2</span>
                            </div>
                            <div class="zone-tir" id="zone-tir-3" data-id="3" data-label="ZONE 3">
                                <span>ZONE 3</span>
                            </div>
                            <div class="zone-tir" id="zone-tir-4" data-id="4" data-label="ZONE 4">
                                <span>ZONE 4</span>
                            </div>
                            <div class="zone-tir" id="zone-tir-5" data-id="5" data-label="ZONE 5">
                                <span>ZONE 5</span>
                            </div>
                            <div class="zone-tir" id="zone-tir-6" data-id="6" data-label="ZONE 6">
                                <span>ZONE 6</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="workflow-tir" data-page="2" style="display:none;">
                    <div class="div-cage">
                        <div id="zone-cage">
                            <div class="zone-shoot" id="zone-shoot-1" data-id="1" data-label="ZONE A">
                                <span>A</span>
                            </div>
                            <div class="zone-shoot" id="zone-shoot-2" data-id="2" data-label="ZONE B">
                                <span>B</span>
                            </div>
                            <div class="zone-shoot" id="zone-shoot-3" data-id="3" data-label="ZONE C">
                                <span>C</span>
                            </div>
                            <div class="zone-shoot" id="zone-shoot-4" data-id="4" data-label="ZONE D">
                                <span>D</span>
                            </div>
                            <div class="zone-shoot" id="zone-shoot-5" data-id="5" data-label="ZONE E">
                                <span>E</span>
                            </div>
                            <div class="zone-shoot" id="zone-shoot-6" data-id="6" data-label="ZONE F">
                                <span>F</span>
                            </div>
                            <div class="zone-shoot" id="zone-shoot-7" data-id="7" data-label="ZONE G">
                                <span>G</span>
                            </div>
                            <div class="zone-shoot" id="zone-shoot-8" data-id="8" data-label="ZONE H">
                                <span>H</span>
                            </div>
                            <div class="zone-shoot" id="zone-shoot-9" data-id="9" data-label="ZONE I">
                                <span>I</span>
                            </div>
                        </div>
                    </div>
                    <div class="div-retour">
                        <span class="btn-retour">
                            RETOUR
                        </span>
                    </div>
                </div>
                <div class="workflow-tir" data-page="3" style="display:none;">
                    <div class="div-resultat">
                        <div class="case-resultat" data-id="0" data-label="ARRET">
                            <span>ARRET</span>
                        </div>
                        <div class="case-resultat" data-id="1" data-label="BUT">
                            <span>BUT</span>
                        </div>
                    </div>
                    <div class="div-retour">
                        <span class="btn-retour">
                            RETOUR
                        </span>
                    </div>
                </div>
                <div class="workflow-tir" data-page="4" style="display:none;">
                    <div class="div-gardien">
                    
                    <%
						Iterator ip = ((Collection)request.getAttribute("listGardiens")).iterator();
						while(ip.hasNext()) {
						Gardien gardien = (Gardien)ip.next();
					%>
					
					<div class="case-gardien case-gardien" data-id="<%= gardien.getId() %>" data-label="Laurence Parisot">
                            <div class="case-gardien-photo">
                                <img src="img/gardien1.jpg"/>
                            </div>
                            <div class="case-gardien-nom">
                                <span><%= gardien.getPrenom() %></span>
                            </div>
                            <div class="case-gardien-choix">
                                <span class="glyphicon glyphicon-ok fa-2x"></span>
                            </div>
                        </div>
					<%
					}
					%>       
               
                    </div>
                    <div class="div-retour">
                        <span class="btn-retour">
                            RETOUR
                        </span>
                    </div>
                </div>
                <div class="workflow-tir" data-page="5" style="display:none;">
                    <div class="div-confirmation">
                        <h3>Confirmation</h3>
                        <span class="case-confirmation-label">Zone de tir : </span>
                        <span class="case-confirmation-tir"> </span>
                        <span class="case-confirmation-label">Zone de shoot : </span>
                        <span class="case-confirmation-shoot"> </span>
                        <span class="case-confirmation-label">R&eacute;sultat : </span>
                        <span class="case-confirmation-resultat"> </span>
                        <span class="case-confirmation-label">Gardien : </span>
                        <span class="case-confirmation-gardien"> </span>
                        <span class="btn-confirmer">
                            CONFIRMER
                        </span>
                    </div>
                    <div class="div-retour">
                        <span class="btn-retour">
                            RETOUR
                        </span>
                    </div>
                </div>
            </div>
            <div class="row" id="indicateur-workflow">
                <div id="indicateur">
                    <div id='ligne-indicateur'></div>
                    <div class="case-indicateur case-indicateur-active" data-id="1">
                        <p>Choix d'une zone de tir</p>
                        <span class="glyphicon glyphicon-ban-circle"></span>
                    </div>
                    <div class="case-indicateur" data-id="2">
                        <p>Choix d'une zone de shoot</p>
                        <span class="glyphicon glyphicon-ban-circle"></span>
                    </div>
                    <div class="case-indicateur" data-id="3">
                        <p>Choix du résultat</p>
                        <span class="glyphicon glyphicon-ban-circle"></span>
                    </div>
                    <div class="case-indicateur" data-id="4">
                        <p>Choix du gardien</p>
                        <span class="glyphicon glyphicon-ban-circle"></span>
                    </div>
                    <div class="case-indicateur" data-id="5">
                        <p>Confirmation</p>
                        <span class="glyphicon glyphicon-ban-circle"></span>
                    </div>
                </div>
            </div>
            
        </div>
        <footer>
            <div class="container">
                <div id="textfooter">@2016 Pierre Lardy . Tout droits réservés | <a>Mentions légales </a> | <a>CGV</a></div>
                
            </div>
        </footer>
            <script src="js/vendor/jquery.mixitup.js"></script>

            <script>
                
                var zone_tir_id;
                var zone_shoot_id;
                var gardien_id;
                var resultat_id;
                var zone_tir;
                var zone_shoot;
                var gardien;
                var resultat;
                var match_id=1;
                
                function Moveworkflow(id_page){
                    $(".case-indicateur").removeClass("case-indicateur-active");
                    $(".case-indicateur[data-id=" + id_page + "]").addClass("case-indicateur-active");
                    $(".workflow-tir").hide();
                    $(".workflow-tir[data-page=" + id_page + "]").show();
                }
                
                $(function(){
                    $(".prt-img-solo").hover(function(){
                        $(this).find(".overlayprt").fadeIn(200);
                    },function(){
                        $(this).find(".overlayprt").fadeOut(200);
                    });
                   
                   $(".btn-retour").click(function(){
                      id = $(".case-indicateur-active").attr("data-id");
                      Moveworkflow(id-1);
                   });
                   $(".zone-tir").click(function(){
                       zone_tir_id = $(this).attr("data-id");
                       zone_tir = $(this).attr("data-label");
                       $(".case-confirmation-tir").html(zone_tir);
                       Moveworkflow(2);
                   });
                   $(".zone-shoot").click(function(){
                       zone_shoot_id = $(this).attr("data-id");
                       zone_shoot = $(this).attr("data-label");
                       $(".case-confirmation-shoot").html(zone_shoot);
                       Moveworkflow(3);
                   });
                   $(".case-resultat").click(function(){
                       resultat_id = $(this).attr("data-id");
                       resultat = $(this).attr("data-label");
                       $(".case-confirmation-resultat").html(resultat);
                       Moveworkflow(4);
                   });
                   $(".case-gardien").click(function(){
                       gardien_id = $(this).attr("data-id");
                       gardien = $(this).attr("data-label");
                       $(".case-confirmation-gardien").html(gardien);
                       Moveworkflow(5);
                   });
                   $('input[type=radio][name=match]').change(function() {
                	   match_id = $('input[name=match]:checked').val(); 
                	   console.log(match_id);

                    });
                   $(".btn-confirmer").click(function(){
                	   $.ajax({
                		    type: 'POST',
                		    url: 'http://localhost:8080/ProjectHockeyWeb/SaisieExecuteServlet',       		    
                		    data: { 
                		    	 "zone_tir_id" : zone_tir_id,
                                 "zone_shoot_id" : zone_shoot_id,
                                 "gardien_id": gardien_id,
                                 "resultat_id" : resultat_id,
                                 "match_id" : match_id
                		    },
                		    success: function(msg){
                		        alert('wow' + msg);
                          	   	Moveworkflow(1);
                		    },
                		    error:function()
                		    {
                         	   Moveworkflow(1);
								alert('erreur');
                     		}
                		});
                   });
                var positionElementInPage = $('nav').offset().top;
               $(window).scroll(
                function(){
                    var x = $(window).scrollTop();
                    if(x < positionElementInPage){
                        $('nav').removeClass('navbar-fixed-top');
                    }
                    else{
                        $('nav').addClass('navbar-fixed-top');
                    }
                });
                
                $('.bloccompetence').hover(function(){
                    $(this).find('.overlaycompetence').show("fast");
                },function(){
                    $(this).find('.overlaycompetence').hide("fast");
                });
                    
                     $('#prt-img').mixItUp();  
                   
                   $(".prt-button").click(function(){
                         var $current = $(this);
                      
                        if ( $current.hasClass( "actif" ) ){		
                                $current.removeClass("actif");
                                $('#allfilter').get(0).click();
                        } else {
                               $('.prt-button').removeClass("actif");
                        $current.addClass("actif"); 
                        }                     
                         
                    });
                    
                  $('.js-scrollTo').on('click', function() { // Au clic sur un élément
			var page = $(this).attr('href'); // Page cible
			var speed = 750; // Durée de l'animation (en ms)
			$('html, body').animate( { scrollTop: $(page).offset().top }, speed ); // Go
			return false;
		});
                    
                });
                
               
            </script>     
    </body>
</html>
