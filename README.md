# smallProjectsWithDatabase
A collection of small training projects with database


## Description
The repository is used to store small projects with database

## Technologies 
Here is the list of technologies that were used during development of these micro-projects:

* Java 1.8
* Spring / SpringBoot
* REST
 
 Baza danych: 
* h2
* SQLlite


## Getting Started
 
 
### Executing programs
This is a list of projects and startup instructions.

#### Supplement-store
The supplement store is used to get, add, delete, replace for supplements divided into individual categories

* Open the supplement-store program module.
* Run the `SupplementStoreApplication` class.

* Make POST request in postman.

BODY:

{
    "name": "Produkt"
}

Url:
    
    http://localhost:8089/zeroCalories/addZeroCalorie
    
    http://localhost:8089/vitamins/addVitamins
    
    http://localhost:8089/protein/addProtein
    
    http://localhost:8089/food/addFood
    
    http://localhost:8089/glutamine/addGlutamine
    
    http://localhost:8089/fatBurner/addFatBurner
    
    http://localhost:8089/creatine/addCreatine
    
    http://localhost:8089/carbo/addCarbo
    
    http://localhost:8089/bcaa/addBcaa
    
    http://localhost:8089/bars/addBars

* Make GET request in postman. 

  Check which id in the console at the very bottom has the product added and write id after =
  
 
 Url: 
 
    http://localhost:8089/zeroCalories/getZeroCalorie?zeroCalorieId=897
    
    http://localhost:8089/vitamins/getVitamins?vitaminsId=961
       
    http://localhost:8089/protein/getProtein?proteinId=993
       
    http://localhost:8089/food/getFood?foodId=1057
       
    http://localhost:8089/glutamine/getGlutamine?glutamineId=1089
       
    http://localhost:8089/fatBurner/getFatBurner?fatBurnerId=1121
       
    http://localhost:8089/creatine/getCreatine?creatineId=1153
       
    http://localhost:8089/carbo/getCarbo?carboId=1185
       
    http://localhost:8089/bcaa/getBcaa?bcaaId=1217
       
    http://localhost:8089/bars/getBars?barsId=1249

* Make PUT request in postman.


BODY:

{
	"id": 961,
    "name": "ZERO"
}

Url:
 
    http://localhost:8089/zeroCalories/putZeroCalories
    
    http://localhost:8089/vitamins/putVitamins
    
    http://localhost:8089/protein/putProtein
    
    http://localhost:8089/food/putFood
    
    http://localhost:8089/glutamine/putGlutamine
    
    http://localhost:8089/fatBurner/putFatBurner
    
    http://localhost:8089/creatine/putCreatine
    
    http://localhost:8089/carbo/putCarbo
    
    http://localhost:8089/bcaa/putBcaa
    
    http://localhost:8089/bars/putBars
    
* Make DEL request in postman.

    Check which id in the console at the very bottom has the product added and write id after =
    
Url:

    http://localhost:8089/zeroCalories/deleteZeroCalorie?zeroCalorieId=897
    
    http://localhost:8089/vitamins/deleteVitamins?vitaminsId=961
    
    http://localhost:8089/protein/deleteProtein?proteinId=1025
    
    http://localhost:8089/food/deleteFood?foodId=1057
    
    http://localhost:8089/glutamine/deleteGlutamine?glutamineId=1089
    
    http://localhost:8089/fatBurner/deleteFatBurner?fatBurnerId=1121
    
    http://localhost:8089/creatine/deleteCreatine?creatineId=1153
    
    http://localhost:8089/carbo/deleteCarbo?carboId=1185
    
    http://localhost:8089/bcaa/deleteBcaa?bcaaId=1217
    
    http://localhost:8089/bars/deleteBars?barsId=1249
    
#### Library
Small library projects in MySQL

* Open the library program module.
* Run the `Main` class.

## Authors
 
Sylwia Tomczak
[LinkedIn](https://www.linkedin.com/in/syltom/) 