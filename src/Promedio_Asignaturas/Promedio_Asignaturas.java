
package Promedio_Asignaturas;
import javax.swing.JOptionPane;
/**
 * Hay que cortar  el método luego de igualar SUMA en el segundo caso
 *
 * @author Juan Valencia
 */ 
public class Promedio_Asignaturas {

   
    
    public static void main(String[] args) 
   {
       int nnotas = 0; int contador1 = 0; int sw1 = 1; int contador2 = 0; int sw2;
       float nota; float suma = 0; float promedio = 0 ; float acum_pp = 0; float acum_creditos = 0; float creditos = 0; float prom_ponderado = 0; float porcentaje = 0;
       String asignatura = ""; String acum_texto2 = "El promedio para la(s) asignatura(s) es:\n"; String acum_texto1;
       JOptionPane.showMessageDialog(null,"Bienvenido, esta aplicación le ayudará a calcular el promedio de una o varias asignaturas");
       while (sw1 == 1)
       {
       asignatura = JOptionPane.showInputDialog(null,"Ingrese el nombre de la asignatura");
       creditos = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el número de créditos de la asignatura"));
       nnotas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de notas a calcular"));
       sw2 = Integer.parseInt(JOptionPane.showInputDialog(null,"¿Todas las notas tienen el mismo valor? 1-> Si  2-> No"));
       while (sw2 <1 || sw2 > 2)
       {
           JOptionPane.showMessageDialog(null, "Selección invalida");
           sw2 = Integer.parseInt(JOptionPane.showInputDialog(null,"¿Todas las notas tienen el mismo valor? 1-> Si  2-> No"));
       }
       while (nnotas <= 0)
               {
                   nnotas = Integer.parseInt(JOptionPane.showInputDialog(null,"La cantidad de notas ingresadas no es valida, inserte el número de notas a promediar"));
               }
       switch (sw2)
       {
           case 1:
           while (contador1 <= (nnotas-1))
           {
               nota = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese la CALIFICACIÓN de la nota #(" + (contador1+1) + "/" + nnotas + ")"));
               while (nota > 5 | nota < 0)
               {
                   nota = Float.parseFloat(JOptionPane.showInputDialog(null,"La calificación ingresada no es valida, ingrese la CALIFICACIÓN de la nota #(" + (contador1+1) + "/" + nnotas + ")"));
               }
               suma = suma + nota;
               contador1++;
           }
           promedio = suma/nnotas;
       case 2:
           float acum_porcentaje = 0;
           while (contador1 <= (nnotas-1))
           {   
              if (contador1 > 0)
              {
                  JOptionPane.showMessageDialog(null, "El porcentaje faltante por distribuir es: " + (100-acum_porcentaje)+ "%");
              }
              porcentaje = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el PORCENTAJE de la nota #(" + (contador1+1) + "/" + nnotas + ")" ));
              nota = Float.parseFloat(JOptionPane.showInputDialog(null,"Ingrese la CALIFICACIÓN de la nota #(" + (contador1+1) + "/" + nnotas + ")"));
              acum_porcentaje = acum_porcentaje + porcentaje;
              while (nota > 5 || nota < 0)
               {
                   nota = Float.parseFloat(JOptionPane.showInputDialog(null,"La calificación ingresada no es valida, ingrese la CALIFICACIÓN de la nota # (" + (contador1+1)));
               }
              if (contador1 == (nnotas-1))
              {
                  if (acum_porcentaje < 100 || acum_porcentaje > 100)
                  {
                     JOptionPane.showMessageDialog(null,"El valor de los porcentajes ingresados es diferente al 100%, por favor, ingrese nuevamente las notas y sus respectivos porcentajes");
                     contador1 = 0;
                     acum_porcentaje = 0;
                     suma = 0;
                  }else{
                     promedio = suma;
                  }
                  break;
              }else{
              suma = suma + (nota*(porcentaje/100));
              contador1++;
              }
           }
        default:
       }
       acum_texto1 = asignatura + " es: " + promedio + "\n";
       acum_texto2 = acum_texto2 + acum_texto1 + "\n";
       JOptionPane.showMessageDialog(null,acum_texto2);
       sw1 = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Desea calcular otra asignatura?\n1-> Si\nOtro-> No"));
       acum_creditos = acum_creditos + creditos;
       acum_pp = acum_pp + (promedio*creditos);
       if (sw1 == 1)
       {
           contador2++;
       }
       contador1 = 0;
       promedio = 0;
       suma = 0;
       }
       /*
       prom_ponderado = acum_pp / acum_creditos;
       if (contador2 < 0 || contador2 > 0)
       {
       JOptionPane.showMessageDialog(null,"El promedio ponderado de las asignaturas es: " + prom_ponderado);
       }
**/
    }
}
