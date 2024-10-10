# Documentation

La première partie des tests couvre la classe *Camera* du package *Preview*. Vous trouverez ces tests dans le fichier [CameraTest.java](https://github.com/HarryGeoffrion/Makelangelo-software/blob/master/src/test/java/com/marginallyclever/makelangelo/preview/CameraTest.java). La classe *Camera* est importante à tester, car c'est elle qui contrôle l'outil de visualization de l'usager. Si une erreur y est présente, l'usager pourrait assumer qu'elle provient d'une des autres classes plutôt que de la visualization du output de ces classes. Pour s'assurer du bon fonctionnement de la caméra, nous testons toutes méthodes qui font quelque chose de plus que juste modifier 
la valeur d'une variable.

*CameraTest* contient les méthodes de tests suivantes:

### [testZoomOut()](https://github.com/HarryGeoffrion/Makelangelo-software/blob/master/src/test/java/com/marginallyclever/makelangelo/preview/CameraTest.java#L31C17-L31C28)
Validation du zoom out  

### [testZoomIn()](https://github.com/HarryGeoffrion/Makelangelo-software/blob/master/src/test/java/com/marginallyclever/makelangelo/preview/CameraTest.java#L47C17-L47C27)
Validation du zoom in

### [testMoveRelative()](https://github.com/HarryGeoffrion/Makelangelo-software/blob/master/src/test/java/com/marginallyclever/makelangelo/preview/CameraTest.java#L64C17-L64C33)
Validation du déplacement de la caméra

### [testScreenToWorldSpace()](https://github.com/HarryGeoffrion/Makelangelo-software/blob/master/src/test/java/com/marginallyclever/makelangelo/preview/CameraTest.java#L95C17-L95C39)
Validation du convertissement des coordonnées sur une image en fonction du zoom et de la position relative de la caméra

### [testZoomToFit()](https://github.com/HarryGeoffrion/Makelangelo-software/blob/master/src/test/java/com/marginallyclever/makelangelo/preview/CameraTest.java#L146C17-L146C30)
Validation du zoom de la caméra pour preview des dimensions spécifiques



La seconde série de tests se font sur la class Turtle. Les tests sont dans le fichier [TurtleTest.java](https://github.com/HarryGeoffrion/Makelangelo-software/blob/master/src/test/java/com/marginallyclever/makelangelo/turtle/TurtleTest.java). Cette classe est une partie intégrale du programme, car c'est l'outil de dessin qui est utilisé en tout temps. Toute erreure dans cette classe sera immédiatement visible et pourrait causer des ennuis aux usagers et modifier leur dessin. 

Voici les méthodes qui ont été testées dans la class *TurtleTest*:

### [testCountLoops()](https://github.com/HarryGeoffrion/Makelangelo-software/blob/master/src/test/java/com/marginallyclever/makelangelo/turtle/TurtleTest.java#L301C17-L301C31)
Validation du compte des "loops"

### [reset()](https://github.com/HarryGeoffrion/Makelangelo-software/blob/master/src/test/java/com/marginallyclever/makelangelo/turtle/TurtleTest.java#L350C17-L350C22)
Validation du reset à l'état initial de la tortue

### [drawArc()](https://github.com/HarryGeoffrion/Makelangelo-software/blob/master/src/test/java/com/marginallyclever/makelangelo/turtle/TurtleTest.java#L371C17-L371C24)
Validation du dessin d'une arc sur le graphique avec la tortue

### [testAddLineSegments()](https://github.com/HarryGeoffrion/Makelangelo-software/blob/master/src/test/java/com/marginallyclever/makelangelo/turtle/TurtleTest.java#L397C17-L397C36)
Validation de l'ajout de segments de lignes droites 

### [getBoundsInternal()](https://github.com/HarryGeoffrion/Makelangelo-software/blob/master/src/test/java/com/marginallyclever/makelangelo/turtle/TurtleTest.java#L419C17-L419C34)
Validation de la fonction qui retourne si un point est véritablement dans les borne de l'image

