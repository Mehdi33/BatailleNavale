



public class ddd {

        /**
         * @param args
         */
        ////////////////////////////////////// PROCEDURES /////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////PROCEDURES/////////////////////////////////////////////
        
        
        /////////////////////// AFFICHAGE du TABLEAU //////////////////
        static void show(int[][] tableau) 
        {       
                        int affc=0;
                for(int i = 0; i<5; i++)                        
        {               
                        
                   System.out.print(affc+"-");  
                   affc=affc+1;
          for(int j = 0; j<10; j++)
          {               
            System.out.print((tableau[i][j]));  
          }
          System.out.println("");   
        }               
                                        
        }       
        ///////////////// PROCEDURE POSAGE BATEAU /////////////////////
        static void bateau(int[][] tableau ,int l, int c, String align)
        {       
                // Horizontal
                if(align=="H")
                {
                        for(int j=c; j<(c+3); j++)
                {    
                                tableau[l][j]=1;                        
                }
                }               
                // Vertical
        if(align=="V") 
        {
                for(int i=l; i<(l+2); i++)
                {    
                                tableau[i][c]=1;
                }
        }
        }
        ///////////////// PROCEDURE TOUCHE ou COULE //////////////////
        static void tir(int[][] tableau,int[][] tjoueur,int l1,int c1) 
        {       
                int count=0;
                // SI TOUCHE
                if(tableau[l1][c1]==1)
                {                       
                        System.out.println("\n|||||||||RESULTAT|||||||||||  ");    
                        System.out.println("\n |____Touché !____|\n");                         
                        tjoueur[l1][c1]=1;
                        
                        // Verification coulé
                        for(int c=0; c<10; c++) // Pour le bateau horizontal
                {                               
                                if(tjoueur[l1][c]==1)
                                {                                               
                                        count=count+1;                                  
                                        if(count==3) // si il y a 3 "1" sur une ligne, alors :Yeehaaa !
                                        {       
                                                System.out.println("\n|||||||||RESULTAT||||||||||");   
                                                System.out.println("\n------- Frégate à 3 Cases coulé !! --------\n");                                               
                                        }
                                }
                }
                        count=0;
                        
                        for(int l=0; l<5; l++) // Pour le bateau vertical
                {    
                                if(tjoueur[l][c1]==1)
                                {
                                        count=count+1;
                                        if(count==2) // si il y a 2 "1" sur une colonne, alors : BOUM
                                        {
                                                System.out.println("\n|||||||||RESULTAT||||||||||");    
                                                System.out.println("\n---- Destroyer à 2 Cases coulé !! ----\n");                                             
                                        }
                                }
                }
                        // FIN DE LA VERIFICATION
                }
                // SI PAS TOUCHE
                else
                {
                        System.out.println("\n|||||||||RESULTAT||||||||||");   
                        System.out.println("\n----Plouf ! Rien en vue captain !\n");   
                }
                
        }
        //////////////// FONCTION DE VERIFICATION DE FIN ////////////////
        
        static int fin(int[][] tjoueur) {
                
                int somme=0;
                
                for(int i = 0; i<5; i++)
        {    
          for(int j = 0; j<10; j++)
          {               
            somme=somme+tjoueur[i][j];
          }  
        }                       
                return(somme);
        }       
        ///////////////// FONCTION POUR EMPECHER LA POSE DE BATEAUX TROP PROCHES //////////////////
        static boolean test(int[][] tableau)
        {
        boolean test = false;
        int count=0;
        
        for(int i = 0; i<5; i++)
    {           
        
                for(int c=0; c<10; c++) // horizontal
        {                               
                        if(tableau[i][c]==1)
                        {                                               
                                count=count+1;                                  
                                if(count>3) 
                                {                                       
                                        test=true;      
                                }
                                
                        }
                        else{
                                count=0;
                        }
        }
    }
                count=0;
        for(int c = 0; c<9; c++)
        { 
                for(int l=0; l<5; l++) // vertical
        {    
                        if(tableau[l][c]==1)
                        {
                                count=count+1;
                                if(count>2) 
                                {
                                        test=true;
                                }
                        }
                        else{
                                count=0;
                        }
        }
        }
                return(test);
        }
        //////////////////// FIN DES PROCEDURES et FONCTIONS//////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////
        
        // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // // /
         
        
}
