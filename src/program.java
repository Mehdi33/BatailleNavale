import java.util.Scanner;
public class program {

	public static void main(String[] args)
    { 
            // TODO Auto-generated method stub
            @SuppressWarnings("resource")
            Scanner saisie = new Scanner(System.in);
            
            ddd d= new ddd();
            
            int[][] tableau=new int[5][10]; // tableau pour le plateau - � ne pas afficher
            int[][] tjoueur=new int[5][10]; // tableau vu par le joueur - � afficher
            int[][] tanti=new int[5][10]; // tableau pour recap les coups tir�s. -eviter aussi de tirer au m�me endroit.
            //------Variables d�clar�es-----------
            int ligne; 
            int colonne;
            int compteur=1;
            //posons nos bateaux !  
            
            int bl=(int)( Math.random()*4);
            int bc=(int)( Math.random()*7);                         
            int bll=(int)( Math.random()*4);
            int bcc=(int)( Math.random()*7);
            
            d.bateau(tableau,bl,bc,"H");               
            d.bateau(tableau,bll,bcc,"V"); 
            
            // on a besoin de savoir avec d�ja 2 bateaux pos�s.
                    
            while(d.test(tableau)!=false || d.fin(tableau)<5) // si test=true, alors les bateaux sont align�s,
            {
                    if(d.test(tableau)!=false || d.fin(tableau)<5) // et si fin(tableau)<5, la somme du tableau est inf�rieure � 5, donc ils sont confondus.
                    {
                            tableau=new int[5][10]; // on reset le tableau, pour eviter l'ajout de bateaux
                            
                    }
                     bl=(int)( Math.random()*4); // on reg�n�re tout.
                     bc=(int)( Math.random()*7);            
                     bll=(int)( Math.random()*4);
                     bcc=(int)( Math.random()*7);                   
                     
                     d.bateau(tableau,bl,bc,"H");              // on repose les bateaux
                     d.bateau(tableau,bll,bcc,"V");
            }
            
                            
            // affichons la situation initiale (tableau sans bateau) :      
            System.out.println("|�����������������������������|\n||||||| TABLEAU DE BORD |||||||\n_______________________________\n\n  0123456789\n  ..........");
            d.show(tjoueur);
            
            /////////////////////////////////////TRAITEMENT//////////////////////////////////
            /////////////////////////////////////PRINCIPAL///////////////////////////////////
            
            while(d.fin(tjoueur)!=5)
            {
                    
                    
                    do{
                            
                            System.out.println("\n////////////// TIR n�"+compteur+" : Pr�paration \\\\\\\\\\\\");   
                            
                            //////////////
                            do{
                                    System.out.println("Saisissez la position verticale de votre tir (de 0 � 4 compris):");   
                                    ligne = saisie.nextInt();
                            }while(ligne<0 || ligne>4); // evitons que l'on tire hors du tableau ...
                    
                            ////
                            
                            do{
                                    System.out.println("Saisissez la position horizontale de votre tir (de 0 � 9 compris):");   
                                    colonne = saisie.nextInt();                     
                            }while(colonne>9 || colonne<0); // evitons de sortir du tableau ...
                    
                            //////////////
                            
                            
                            if(tanti[ligne][colonne]==1) // Evitons de tirer au m�me endroit, l'archarnement ne sert � rien :D
                            {
                                    System.out.println("Vous avez d�j� tir� � cette position");
                                    if(tjoueur[ligne][colonne]==1) // Histoire de pr�ciser si cette case �tait un bateau touch�e
                                    {
                                            System.out.println("De plus vous y aviez touch� un navire ennemi, Recommencez :");
                                    }
                                    else{
                                            System.out.println("Recommencez avec une nouvelle position � attaquer :");
                                    }
                            }
                    
                    }while(tjoueur[ligne][colonne]==1);   // pour eviter de tirer sur un bateau d�ja tir�
                    tanti[ligne][colonne]=1;
                    compteur=compteur+1;                                             //comptons le nombre de bombes
                    d.tir(tableau,tjoueur,ligne,colonne);     //tirons !
                    System.out.println("________________________________\n||||||| TABLEAU DE BORD  |||||||\n��������������������������������\n\n  0123456789\n  ..........");
                    d.show(tjoueur);                                                     //Affichons le resultat !            
                    System.out.println("\n/////R�capitulatif des tirs pr�c�dents : \n");
                    System.out.println("/X/X/X/X/X/X");
                    d.show(tanti);
                    System.out.println("/X/X/X/X/X/X");                     
            }               
            
            
            ////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////FIN DU TRAITEMENT PRINCIPAL/////////////////
            
            
                //////////////////////  BLABLA de fin /////////////////////////
            System.out.println("\n\n|������������������������������������������������������������������������������������������������������|");   
            
            System.out.println("////////////// Bravo CAPITAINE, vous avez �radiqu�e les forces navales ennemies \\\\\\\\\\\\");   
            
            // Histoire de s'amuser, des messages persos en fonction du nombre de missiles envoy�s:
            // ( oui des missiles, c'est une bataille moderne ! :D )
            if(compteur<10)
            {
                    System.out.println("\n////////////// Gr�ce � vos talents de strat�ge, seulement "+(compteur-1)+" missiles ont suffit! \\\\\\\\\\\\\\");
                    System.out.println("////////////// Notre Nation vous est reconnaissante ! Vous �tes un h�ros \\\\\\\\\\\\\\");
                    // Si on y parvient en moins de 10 coups, c'est du talent.
            }
            else{
                    
            if(compteur<25 && compteur>10)
            {
                    System.out.println("////////////// Il nous aura fallut du temps, et "+(compteur-1)+" missiles, mais vous y �tes parvenu ! \\\\\\\\\\\\\\");
                    
            }
            else{ 
                    System.out.println("////////////// Capitaine, Grace � "+(compteur-1)+" missiles, nous sommes victorieux ! \\\\\\\\\\\\\\");
                    System.out.println("////////////// Mais c'est un lourd cout pour notre nation, am�liorez vous ! \\\\\\\\\\\\"+"\n|____________________________________________________________________________________| ");
            }
            System.out.println("////////////// AU REVOIR CAPITAINE !!");
            }
            ///// Enfin fini ! Merci pour ce Challenge super int�ressant ! --la programmation, c'est mon truc :D --
    }

}
