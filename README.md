![Titulo del proyecto conversor de unidades](https://github.com/SayulRamirez/Conversor/assets/131827632/de2d92bd-5f0b-4929-a3cf-c0347c188860)

## Descripcion del proyecto

El converor de unidades es un programa con una interfaz de usuario para escritorio que a grandes rasgos convierte unidades.
En un principio solo esta la conversión de ***temperaturas y divisas***. La conversión de divisas implementa la API de Exchangerate,
en ella se utilizan las ***161*** monedas mundiales, así que puedes hacer cualquier conversión.

El pryecto se realizo gracias al programa ONE de alura latam y oracle, gracias.

## :hammer:Funcionalidades del proyecto

- `Menu de conversiones disponibles:`De momento solo estan disponibles la conversión de divisas y de temperature.<br>
  <br>![Menú del programa](https://github.com/SayulRamirez/Conversor/assets/131827632/26e80750-8c1a-4664-b1e1-401a9a313a6e)
       
<br><br>
- `Conversión de divisas con conexión o sin conexción`: Permite la conversión de divisas, esto dependiendo si se tiene
  conexión a internet o no.<br>
  <br>![Pantalla de conversión de divisas](https://github.com/SayulRamirez/Conversor/assets/131827632/410fad57-b977-431b-9f06-6480914e3fb2)
    
<br>
1. Sin conexión: El programa detecta si se tiene conexión a internet, si no se tiene entrara el el modo sin 
   conexión. En el se utilizan solo pocas monedas de cambio y con una taza fija aproximada.
2. Con conexión: En este apartado se implementa la API para la conversión en tiempo real. Si cuenta con conexión a internet
   podra consultar los 161 tipos de conversión disponibles y en tiempo real.

<br><br>
-  `Pantalla de las conversiones de temperaturas:` Te permite pasar de cualquier unidad de temperature.
  Las unidades disponibles son: Celsius, Fahrenheit, Kelvin y Rankine.<br>
  <br>![Pantalla de conversión de temperaturas](https://github.com/SayulRamirez/Conversor/assets/131827632/b026418d-a510-45b5-9ab5-0a6003f5d5d5)
     
<br>

- `Menú en la barra superior:`La ventana principal cuenta con un menú en la barra superior, la función de cada apartado se menciona a continuación.
<br>
1. En el apartado **Opciones** esta disponible ***Cambiar tipo de conversión*** se regresa a la ventana del menú para que puedas cambiar del tipo de conversión.
2. Igualmente en el apartado **Opciones** tiene la opción de ***Salir*** con ella cierras el programa.
3. Esta la opción de ***Limpiar*** para limpiar todos los campos del menú.
4. Y finalmente esta ***Acerca de*** en el se habre una pequeña ventana con infomación del desarrollador y enlaces que te direccionan a la página
   de GitHub y LinkedIn.


## :computer: Tecnologías utilizadas

- `JAVA 17.`
- `Eclipse 2023-03.`
- `Java Swing con WindowBuilder.`
- `Control de versiónes con Git y GitHub.`
- `Exchangerate-api.`
- `JSONObject`

## :man: Desarrolladores

[Saúl Ramírez](https://github.com/SayulRamirez)
