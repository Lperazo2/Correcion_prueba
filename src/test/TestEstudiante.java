package test;
 import dominio.Estudiante;
 import java.util.Scanner;

public class TestEstudiante {
     static Scanner datos = new Scanner(System.in);
    public static void main(String[] args) {
        int nroHombres,ne;      
        System.out.println("INGRESE EL NUMERO DE ESTUDIANTES");
        int n= datos.nextInt();
        Estudiante [] estudiantes = new Estudiante[n];
        llenaEstudiante(estudiantes);
        System.out.println("\n\n\nLISTADO DE ESTUDIANTES ORDENADOS DE MAYOR A MENOR NOTA");
        ordenarEstudiantem(estudiantes);
        System.out.println("\n\n\nLISTADO DE ESTUDIANTES ORDENADOS DE MENOR A MAYOR NOTA");
        ordenarEstudiante(estudiantes);
        nroHombres=porcentajegenero(estudiantes); 
        System.out.println("\n\n\nRESUMEN");
        System.out.println("EL % de HOMBRES ENCIMA DEL PROMEDIO ES : "+porcentajePromedio(estudiantes, nroHombres, 'm'));
        System.out.println("EL % de MUJERES ENCIMA DEL PROMEDIO ES : "+porcentajePromedio(estudiantes, nroHombres, 'f'));
        ne = notaAlta(estudiantes);
        System.out.println("EL ESTUDIANTE CON LA NOTA MAS ALTA ES :"+
                estudiantes[ne].getNombre());
        
    }
    public static void ordenarEstudiantem(Estudiante est[]){
        double nota,notaux;
        String nombre,nombreaux;
        char sexo,sexoaux;       
        boolean bandera=false;
        while (bandera==false){
            bandera=true;
            for(int i=0;i<(est.length-1);i++){
                if (est[i].getNota()<est[i+1].getNota()){
                    notaux=est[i].getNota();
                    nombreaux=est[i].getNombre();
                    sexoaux=est[i].getSexo();
                    
                    nombre=est[i+1].getNombre();
                    sexo=est[i+1].getSexo();
                    nota=est[i+1].getNota();
                    est[i] = new Estudiante(nombre,sexo,nota);
                    
                    est[i+1]=new Estudiante(nombreaux,sexoaux,notaux);
                    bandera=false;
                }
            }
        }
        System.out.println("      NOMBRE  NOTA GENERO");
        for(int i=0;i<est.length;i++){
            System.out.println("      "+est[i]);
        }
    }
    public static void ordenarEstudiante(Estudiante est[]){
        double mayorn,nota,notaux;
        String nombre,nombreaux;
        char sexo,sexoaux;       
        boolean bandera=false;
        while (bandera==false){
            bandera=true;
            for(int i=0;i<(est.length-1);i++){
                if (est[i].getNota()>est[i+1].getNota()){
                    notaux=est[i].getNota();  //guardo la mayor not
                    nombreaux=est[i].getNombre();
                    sexoaux=est[i].getSexo();
                    
                    nombre=est[i+1].getNombre();
                    sexo=est[i+1].getSexo();
                    nota=est[i+1].getNota();
                    est[i] = new Estudiante(nombre,sexo,nota);
                    
                    est[i+1]=new Estudiante(nombreaux,sexoaux,notaux);
                    bandera=false;
                }
            }
        }
        System.out.println("      NOMBRE  NOTA GENERO");
        for(int i=0;i<est.length;i++){
            System.out.println("      "+est[i]);
        }
    }
    public static void llenaEstudiante(Estudiante est[]){
        String nombre;
        char sexo;
        double nota;
        for(int i=0;i<est.length;i++){
            datos.nextLine();
            System.out.println("\n\nEstudiante No "+(i+1));
            System.out.print("Nombre: ");
            nombre = datos.nextLine();
            System.out.println("Sexo: <<m>><<f>> ");
            sexo = datos.next().charAt(0);
            System.out.print("Nota : ");
            nota = datos.nextDouble();
            est[i] = new Estudiante(nombre,sexo,nota);
            
        }
    }
    public  static int  porcentajegenero(Estudiante est[]){
        int cuentahombres=0,cuentamujeres=0;
        double porc;
        for(int i=0;i<est.length;i++){
            if(est[i].getSexo()=='m'){
                cuentahombres++;
            }
        }
        cuentamujeres = est.length-cuentahombres;
        System.out.println("\n\nEN LA CLASE EXISTEN UN TOTAL DE "+est.length+" ESTUDIANTES");
        System.out.println("EL PORCENTAJE DE HOMBRES ES DEL ="+(cuentahombres*100/est.length)+" %.");
        System.out.println("EL PORCENTAJE DE MUJERES ES DEL ="+(cuentamujeres*100/est.length)+" %.");
        porc = cuentahombres*100/est.length;
        return cuentahombres;
    }
    public static double porcentajePromedio(Estudiante est[],int homb,char sex){
        int muj = est.length-homb;
        int cuenta=0;
        double promedio=0,porch,porcm;
        for(int i=0;i<est.length;i++){
            promedio+=est[i].getNota();
        }
        promedio=promedio/est.length;
        
        for(int i=0;i<est.length;i++){
            if(est[i].getNota()>promedio && est[i].getSexo()==sex){
                cuenta++;
            }
        }        
        porch = homb*100/est.length;
        porcm = muj*100/est.length;
        if(sex=='m' && homb>0){
            porch = cuenta * porch/homb;
            return porch;
        }
        else if(muj>0){
            porcm = cuenta * porcm/muj;
            return porcm;
           }
        else{
            return 0;
        }
    }
    public static int notaAlta(Estudiante est[]){
        double mayor;
        int indice=0;
        mayor = est[0].getNota();
        for(int i=1;i<est.length;i++){
            if(est[i].getNota()>mayor){
                mayor = est[i].getNota();
                indice = i;
            }
        }        
        return indice;
    }
}