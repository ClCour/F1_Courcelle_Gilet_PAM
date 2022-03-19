L'application permet de récupérer des recettes de cuisine sous forme d'images à partir de l'API Spoonacular.

A l'ouverture, l'utilisateur choisit entre trois menus :
- Rechercher une recette
- Recettes salées
- Recettes sucrées

Les deux derniers choix permettent d'afficher une liste de recettes correspondant au choix. Le premier menu laisse l'utilisateur entrer un terme qui sera recherché dans le nom des recettes (si le terme n'est pas complet, l'application utilise l'autocomplétion). Une liste de recettes correspondantes est alors affichée.

Chaque recette peut être sélectionnée pour être visualisée en détail. Il peut arriver que certaines recettes retournées par l'API ne contiennent en fait pas l'image détaillée. Dans ce cas, un écran avec un message d'erreur s'affiche et l'utilisateur a la possibilité de retourner en arrière.

De la même façon, si aucune recette ne correspond à la recherche de l'utilisateur, un message d'erreur s'affiche et il a la possibilité de retourner au menu.
Remarque : Sur cet écran, il reste un bug que nous n'avons pas réussi à corriger. Si on essaye de retourner en arrière avec la flèche de navigation, il faut appuyer dessus deux fois rapidement pour que cela fonctionne.

L'application supporte la rotation de l'écran.  

Chacun des trois menus est géré par le même fagment qui permet d'afficher une Recycler-view avec différentes recettes. La navigation entre les différents fragments est faite avec le composant NavController.

