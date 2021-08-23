# Ordenamiento-Radixsort-con-archivos
En un repositorio anterior se explico como funcionaba este algoritmo de ordenamiento, existían limitantes que tenía el código y mejoras que se le podrían hacer al mismo para no repetir tanto código.  A pesar de eso, el código en esta ocasión está enfocado a leer datos (números) en un archivo de texto (.txt), presenta las mejoras necesarias para no repetir demasiado código y en está ocasión no existen tantas limitantes, claro que sigue existiendo la condición de que los números deben ser de 4 dígitos, no se han realizado las modificaciones para poder trabajar con números de menos dígitos.

NOTAS DEL CÓDIGO
  - Los números que están en el archivo de texto deben ser de 4 dígitos.
  - Los numeros pueden estár separado por una coma ( , ) y/o espacios en blanco.
  - El resultado de cada iteriación (cuando se regresa al archivo original) y el final, es impreso en el archivo original. Si se quisiera volver a ejecutar el algoritmo con los mismos números o nuevos, es necesario borrar dichas impresiones y solo dejar los números a ordenar. En caso de no hacerlo, existirán errores que impedirán realizar el ordenamiento.
  - Cada archivo auxiliar incluye sus propias iteraciones, para las unidades, decenas, centenas y miles.
  - Es posible ordenar los números de manera ascendente y descentente. Solo cambia el orden en el que se buscan los indices.
  - Existen posibles mejoras que se le pueden hacer al código y que están marcados en el mismo
