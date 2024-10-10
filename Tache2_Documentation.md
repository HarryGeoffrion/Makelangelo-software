# Documentation

La première partie des tests couvrent la classe *Camera* du package *Preview*. Vous trouverez ces tests dans le fichier [CameraTest.java](#file:CameraTest.java-context). La classe *Camera* est importante à tester, car c'est elle qui contrôle l'outil de visualization de l'usager. Si une erreur y est présente, l'usager pourrait assumer qu'elle provient d'une des autres classes plutôt que de la visualization du output de ces classes. Pour s'assurer du bon fonctionnement de la caméra, nous testons toutes méthodes qui font quelque chose de plus que juste modifier 
la valeur d'une variable.

*CameraTest* contient les méthodes de tests suivantes:

### testZoomOut()
Validation du zoom out

### testZoomIn()
Validation du zoom in

### testMoveRelative()
Validation du déplacement de la caméra

### testScreenToWorldSpace()
Validation du convertissement des coordonnées sur une image en fonction du zoom et de la position relative de la caméra

### testZoomToFit()
Validation du zoom de la caméra pour preview des dimensions spécifiques