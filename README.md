
# Projet d'Automatisation de Test ISTQB - Selenium Java pour HighTest

Ce projet d'automatisation de test a été développé dans le but de vérifier que le remplissage correct d'un quiz ISTQB sur le site [Hightest.nc](https://hightest.nc/) conduit à la réception d'un e-mail indiquant un score de 100 % de bonnes réponses.

## Outils Utilisés

* Selenium WebDriver avec Java
* Navigateur Cible : Google Chrome
* Outil de Gestion de Code Source : GitHub

## Scénario de Test

1. Accéder au site [Hightest.nc](https://hightest.nc/).
2. Cliquer sur "Toolbox" pour accéder à la section des outils.
3. Sélectionner le lien vers le quiz ISTQB Fondation en français.
4. Remplir le quiz en cliquant sur les bonnes réponses.
5. Valider le test.
6. Sur la page suivante, entrer une adresse e-mail Yopmail et valider le formulaire.
7. Accéder à [Yopmail](https://yopmail.com/fr/) pour consulter les e-mails reçus.
8. Vérifier que l'e-mail reçu indique un score de 100 % de bonnes réponses.

## Design Pattern Utilisé

Ce projet utilise le modèle de conception Page Object Model (POM) pour organiser et structurer le code d'automatisation des pages Web.

## Comment Contribuer

Si vous souhaitez contribuer à ce projet, vous pouvez créer une branche de fonctionnalité à partir de la branche principale, effectuer vos modifications, puis créer une demande de tirage (Pull Request) pour examiner et fusionner vos modifications dans le code principal.

## Lancement du projet sur votre IDE

* Copier le GitHub de la repo
* Télécharger le projet avec le terminal de l'IDE ou autre
* Dans le dossier du projet , il y'a le fichier de config testng.xml, on peut le lancer de plusieurs manieres en fonction de la préférence (IDE ou ligne de commande)

Pour me contacter : galusfotso184@gmail.com
