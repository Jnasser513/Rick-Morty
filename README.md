# Capturas de pantalla
La aplicacion inicia con un splash creen, luego se muestra un cargando mientras se estan obteniendo los personajes de la API, una vez obtenidos los personajes se procede a mostrar la lista de personajes mediante un LazyColumn

<img src="https://github.com/user-attachments/assets/760f9cc3-e2ad-48b0-b5ee-2d6073450891" alt="WhatsApp Image 2024-09-04 at 12 04 25 PM" width="200" />
<img src="https://github.com/user-attachments/assets/e48ea466-efbf-4b63-89d2-fe09f9a00325" alt="WhatsApp Image 2024-09-04 at 12 04 25 PM" width="200" />
<img src="https://github.com/user-attachments/assets/a2401e56-172f-485f-86d1-afa9d4000292" alt="WhatsApp Image 2024-09-04 at 12 04 25 PM" width="200" />

https://github.com/user-attachments/assets/514e9bad-626d-4e8e-87cb-9f841f0a38e7

# Instrucciones para compilacion y ejecucion del proyecto
- Clonar proyecto utilizando el sigueinte comando: git clone https://github.com/Jnasser513/Rick-Morty.git
- Abrir el proyecto en android studio y esperar a que se compile el proyecto
- Seleccionar un dispositivo fisico o emulador en donde se ejecutara la aplicacion y luego presionar en el boton de play
  
![Captura de Pantalla 2024-09-04 a la(s) 12 20 12](https://github.com/user-attachments/assets/edc53484-44c4-43c0-b3fb-eb5ed6d52f48)

# Explicacion del proyecto
El proyecto se dividio por features y una carpeta core, 
cada carpeta equivale a un feature y dentro de cada feature encontraremos 3 carpetas principales (domain, data y presentation).

Comenzando con la capa de core en esta se encuentran recursos que se utilizaran dentro de toda la aplicacion y seran reutilizables, 
este modulo se divide en 3 capas (domain, data y presentation) en la capa de domain encontraremos el manejo de resultados, errores y clases de dominio, 
en la capa de data encontraremos la configuracion de el cliente de consumo http asi como metodos para facilitar el consumo de estos servicios y por ultimo en la capa de presentation 
encontraremos componentes que se reutilizaran en toda la aplicacion y la configuracion de el tema de la aplicacion.

Luego tenemos un modulo para el feature de la lista de personajes, este se divide en 3 capas (domain, data y presentation) la capa de domain tiene las abstracciones de el repositorio y el data source, 
en la capa de data encontramos la implementacion de el repositorio y el remote data source y por ultimo en la capa de presentation encontraremos el manejo de las acciones, eventos y 
estados ademas de el viewmodel y la pantalla de personajes.

# Eleccion de librerias
- Ktor como cliente de consumo http
- Koin para inyeccion de dependencias
- Coil para cargar imagenes de internet
- Jetpack Compose para creacion de UI
- MVI para un mejor manejo de acciones del usuario y reaccionar a cambio de estados y eventos
- Coroutines para manejo de hilos y pogramacion asincrona
