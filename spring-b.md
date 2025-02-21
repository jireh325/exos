# **Généralités sur Spring Boot**  

Spring Boot est un framework basé sur **Spring** qui simplifie le développement d’applications Java en offrant une approche opinionated (avec des choix préconfigurés) et en réduisant la quantité de configuration nécessaire. Il est largement utilisé pour développer des applications **web, REST API, microservices**, et bien d’autres types d’applications.



### **Qu’est-ce que Spring ?**
Spring est un framework open-source pour Java qui facilite le développement d’applications d’entreprise en fournissant une architecture modulaire, flexible et puissante.

Spring suit les principes de **l’IoC (Inversion of Control)** et de **l’AOP (Aspect-Oriented Programming)** pour développer des applications robustes, testables et maintenables.  

- **IoC (Inversion of Control)** : Spring gère l’instanciation et l’injection des dépendances à ta place via le **Spring Container** et son moteur **Bean Factory**.

- **AOP (Aspect-Oriented Programming)** : Permet d’appliquer des **cross-cutting concerns** (comme la gestion des transactions, la sécurité, ou la journalisation) sans polluer le code métier.  

### **Pourquoi Spring ?**  
- **Gestion des dépendances** via Spring Core (**IoC Container**)  
- **Abstraction pour la persistance** (Spring Data, JPA, Hibernate)  
- **Gestion des transactions** (Spring Transaction Manager)  
- **Développement web avec Spring MVC**  
- **Sécurisation avec Spring Security**  



## **1. Pourquoi utiliser Spring Boot ?**
- **Configuration minimale** : Moins de fichiers XML, grâce à la configuration basée sur les annotations et `application.properties` ou `application.yml`.  
- **Serveur embarqué** : Tomcat, Jetty ou Undertow intégrés, ce qui évite d’avoir à déployer manuellement un serveur.  
- **Facilité de création de REST API** : Avec `@RestController`, `@GetMapping`, `@PostMapping`, etc.  
- **Gestion automatique des dépendances** : Grâce à **Spring Boot Starter**, plus besoin de gérer manuellement les versions des bibliothèques.  
- **Système de monitoring intégré** : Spring Boot Actuator fournit des endpoints pour surveiller et administrer une application.  
- **Compatibilité avec les microservices** : S’intègre bien avec Spring Cloud pour développer des architectures distribuées.  



## **2. Structure d'une application Spring Boot**  
Une application Spring Boot suit une structure standard :  

```
/mon-projet
│── src/main/java/com/exemple
│    ├── MonProjetApplication.java  (Classe principale)
│    ├── controller/
│    ├── service/
│    ├── repository/
│── src/main/resources
│    ├── application.properties  (Configuration)
│── pom.xml  (Dépendances Maven)
```



## **3. Démarrer une application Spring Boot**  
Il existe plusieurs manières de créer un projet Spring Boot :  

- **Spring Initializr (start.spring.io)** : Méthode la plus simple et recommandée.  
- **Spring Boot CLI** (`spring init`) : Pour ceux qui aiment la ligne de commande.  
- **Manuellement (sans Initializr)** : En créant un projet Maven ou Gradle à la main.  
- **Avec un IDE** (IntelliJ, STS, Eclipse) : Certains IDE ont un assistant intégré.  

### **Spring Initializr : Configurer son projet**
Tout ce dont ont a à faire ici, c'est de faire des choix.

**Options disponibles**
- **Langage** : Java (par défaut), Kotlin, Groovy.  
- **Gestionnaire de paquets** : Maven ou Gradle (Maven recommandé).  
- **Spring Boot Version** : Toujours choisir une **version stable** (ex: `3.2.x`).  
- **Project Metadata** :  
   - **Group** (ex: `com.example`) : Package de base  
   - **Artifact** (ex: `mon-projet`) : Nom du JAR  
   - **Packaging** : JAR (par défaut) ou WAR (pour déploiement sur serveur externe)  
   - **Java Version** : **Java 17+** recommandé  




### **Spring Boot CLI**
Ici grace à **spring init**, on crée un projet en ligne de commande.

ex:

```sh
spring init --dependencies=web,jpa,mysql --name=mon-projet mon-projet --build=maven
```


1. **`spring init`**  
   - C'est la commande du **Spring Boot CLI** qui permet d'initialiser un projet Spring Boot.

2. **`--dependencies=web,jpa,mysql,devtools`**  
Permet de préciser les dépendances que l'on souhaite ajouter au projet dès son initialisation.

3. **`--name=mon-autre-projet`**  
   - Spécifie le **nom** du projet qui sera généré.  
   - Le dossier créé portera ce nom.

4. **`--build=maven`**  
   - Spécifie que **Maven** est l'outil de build à utiliser (**par défaut, c'est Gradle**).  
   - Cela génère un fichier `pom.xml` au lieu d’un `build.gradle`.

5. **`mon-autre-projet`**  
   - Indique le **nom du répertoire** où sera créé le projet.  
   - Si ce paramètre est omis, Spring Boot génère le projet dans le dossier courant.


rendu:

-----------------

Cela générera un projet **Spring Boot** nommé `mon-autre-projet` avec **Maven** comme outil de build, et les dépendances suivantes :  
- `spring-boot-starter-web` (pour développer des API REST)
- `spring-boot-starter-data-jpa` (pour utiliser JPA/Hibernate)
- `mysql-connector-java` (pour se connecter à une base de données MySQL)
- `spring-boot-devtools` (pour le rechargement automatique pendant le développement)




### **Manuellement (sans Initializr)**
Cette methode est l'équivalente de la methode avec **Initializr** mais sans passé par un navigateur.
Il s'agit là de creer un projet **Spring-boot** en ligne de commande par le billet d'un gestionnaire de tache en l'occurence **Maven** ici.

```sh
mvn archetype:generate -DgroupId=com.example -DartifactId=mon-projet -DarchetypeArtifactId=maven-archetype-quickstart
```

1. **`mvn archetype:generate`**  
   - Cette commande utilise **Maven** pour générer un nouveau projet basé sur un **archetype** (modèle de projet préconfiguré).  
   - C'est utile pour créer rapidement une structure de projet standard.

2. **`-DgroupId=com.example`**  
   - Définit le **Group ID**, qui est un **identifiant unique** pour l'organisation ou le projet.  
   - C'est souvent écrit sous la forme d'un nom de domaine inversé (`com.example`, `fr.monsite`, `org.monentreprise`, etc.).
   - Il est utilisé pour éviter les conflits entre projets.

3. **`-DartifactId=mon-projet`**  
   - Définit le **nom du projet** ou **module Maven**.  
   - C'est ce qui apparaîtra dans le nom du dossier du projet et dans le fichier `pom.xml`.

4. **`-DarchetypeArtifactId=maven-archetype-quickstart`**  
   - Indique que l'on veut utiliser l'archetype `maven-archetype-quickstart`, qui génère un projet **Java standard** avec :  
     - Une structure de répertoires (`src/main/java`, `src/test/java`).  
     - Un `pom.xml` configuré pour une application Java basique.  
     - Une classe Java d'exemple (`App.java` dans le package défini par `groupId`).  
     - Un test unitaire avec JUnit.

rendu:

-------------

avec cette methode, il nous est pas possible d'ajouter des des dépendances directement sur la commande pour cela il y'a le fichier pom.xml



## **4. Dépendances essentielles pour une API REST**
| **Dépendance** | **Description** |
|--------------|--------------|
| **Spring Web** | Pour créer une API REST (Spring MVC + Tomcat embarqué) |
| **Spring Boot DevTools** | Auto-reload de l’app lors des modifications |
| **Spring Data JPA** | Abstraction pour interagir avec une base de données |
| **H2 Database / PostgreSQL / MySQL** | Base de données intégrée ou externe |
| **Spring Security** | Sécurisation des endpoints REST |
| **Spring Validation** | Validation des inputs via des annotations |
| **Lombok** | Réduit le boilerplate (Getters, Setters, Constructeurs...) |
| **Spring Boot Actuator** | Monitoring et métriques |

### **Cas spécifiques :**
- **Pour une API en GraphQL : Ajoute `Spring Boot Starter GraphQL`**  
- **Pour du WebSocket : `Spring Boot Starter Websocket`**  
- **Pour des événements asynchrones : `Spring Boot Starter Kafka` ou `RabbitMQ`**  




## **5. Gestion des dépendances dans Spring Boot**
Spring Boot simplifie la gestion des dépendances grâce aux **starters**.  

- **Ancienne façon (sans Spring Boot) :**  
```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-web</artifactId>
    <version>5.3.22</version>
</dependency>
```

- **Avec Spring Boot :**  
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
- **Pas besoin de gérer les versions**, tout est résolu par **`spring-boot-dependencies`** .  




## **6. Architecture et fonctionnement d’un projet Spring Boot**
Un projet Spring Boot suit généralement une architecture **"3-Tiers"** :  

```
Frontend (Angular/React)  ⇄  Backend (Spring Boot)  ⇄  Database (PostgreSQL, MySQL)
```
### **A. Frontend : Appelle l’API**
- Un front en Angular, React, ou VueJS consomme les **endpoints REST** exposés par Spring Boot.  
- Authentification possible via **JWT** ou **OAuth2** (Spring Security).  
- Communication via **HTTP (Axios, Fetch, HttpClient d’Angular)** ou **WebSockets**.  



### **B. Backend (Spring Boot) : Différentes couches**
- **Controller** : Gère les requêtes HTTP et retourne les réponses.  
- **Service** : Logique métier et traitements divers.  
- **Repository (DAO)** : Communication avec la base via Spring Data JPA.  
- **Entity (Modèle)** : Représentation des tables de la base en Java.  
- **Configuration** : Gestion des propriétés (database, sécurité, logs...).  

- Exemple:

#### **Entity (Modèle - Base de Données)**

```java
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
}
```

#### **Repository (Accès à la base)**

```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
```

#### **Service (Logique métier)**

```java
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
```

#### **Controller (Exposition API REST)**

```java
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}
```
- Un simple **`curl http://localhost:8080/users`** retourne la liste des utilisateurs.  



### **C. Database : Stockage et Interactions**
- Spring Boot permet d’utiliser plusieurs types de bases :  
   - **H2 Database** (In-Memory pour dev)  
   - **PostgreSQL / MySQL** (Production)  
   - **MongoDB** (NoSQL)  

- **Configurer la BDD (`application.properties`)** :

```c#
spring.datasource.url=jdbc:mysql://localhost:3306/mon_app
spring.datasource.username=root
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
```
Spring Boot **génère automatiquement les tables** via JPA si `ddl-auto=update`.  



## **7. Cycle de Vie d'une Requête dans Spring Boot**
- **Le client (Angular, Postman, Curl...) envoie une requête HTTP (`GET /users`).**  
- **Spring Boot Route la requête au `UserController`.**  
- **Le `UserService` interagit avec la BDD via `UserRepository`.**  
- **Le `UserRepository` récupère les données depuis MySQL/PostgreSQL.**  
- **Les données sont transformées en JSON et renvoyées au client.**  




## **8. Résumé des Différentes Entités d’un Projet Spring Boot**
| **Composant** | **Rôle** |
|--------------|---------|
| **Controller** | Gère les requêtes HTTP et retourne des réponses |
| **Service** | Contient la logique métier |
| **Repository (DAO)** | Gère l'accès aux données via JPA |
| **Entity** | Représente une table de la BDD |
| **Configuration** | Définit les propriétés de l’application |
| **Security** | Gère l'authentification et l'autorisation |
| **Actuator** | Expose des endpoints pour monitorer l’application |




## **9. Quelques annotations Spring Boot**  

| **Annotation** | **Description** |
|--------------|----------------|
| `@SpringBootApplication` | Active la configuration automatique, la détection des composants et la configuration Spring Boot. |
| `@ComponentScan` | Recherche automatiquement les composants Spring (`@Component`, `@Service`, `@Repository`, etc.). |
| `@EnableAutoConfiguration` | Active la configuration automatique de Spring Boot. |
| `@Configuration` | Indique qu'une classe définit des beans Spring. |
| `@Bean` | Déclare un bean géré par Spring. |
| `@Component` | Déclare un composant générique (Service, Repository, Controller). |
| **Annotations REST** | **Description** |
| `@RestController` | Combine `@Controller` et `@ResponseBody`, utilisé pour créer des APIs REST. |
| `@Controller` | Indique qu'une classe est un contrôleur Spring MVC. |
| `@RequestMapping` | Déclare une route HTTP générique (GET, POST, etc.). |
| `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping` | Spécifie une route HTTP pour chaque type de requête. |
| `@ResponseBody` | Convertit le retour d’une méthode en JSON ou XML. |
| `@RequestParam` | Récupère un paramètre dans l’URL (`/api?name=test`). |
| `@PathVariable` | Récupère un paramètre dynamique dans l’URL (`/api/{id}`). |
| `@RequestBody` | Récupère le corps d'une requête HTTP (JSON, XML). |
| **Annotations Service & Repository** | **Description** |
| `@Service` | Indique qu'une classe est un service métier. |
| `@Repository` | Indique qu'une classe gère l’accès aux données (JPA, JDBC, etc.). |
| `@Transactional` | Gère les transactions (rollback en cas d'erreur). |
| **Annotations JPA & Hibernate** | **Description** |
| `@Entity` | Indique qu’une classe est une entité JPA. |
| `@Table(name="nom_table")` | Spécifie le nom de la table associée à l'entité. |
| `@Id` | Définit la clé primaire d’une entité. |
| `@GeneratedValue(strategy = GenerationType.IDENTITY)` | Génère automatiquement l’ID (auto-incrémenté). |
| `@Column(name="nom_colonne")` | Personnalise le nom d’une colonne. |
| `@OneToOne`, `@OneToMany`, `@ManyToOne`, `@ManyToMany` | Définit les relations entre entités. |
| `@JoinColumn(name="nom_cle_etrangere")` | Définit une clé étrangère dans une relation. |
| **Annotations Spring Security** | **Description** |
| `@PreAuthorize("hasRole('ADMIN')")` | Vérifie si l'utilisateur a un rôle spécifique. |
| `@Secured("ROLE_USER")` | Restreint l'accès à certains rôles. |
| `@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})` | Autorise plusieurs rôles sur une méthode. |
| **Annotations Spring Boot Test** | **Description** |
| `@SpringBootTest` | Lance l'application Spring Boot pour les tests. |
| `@WebMvcTest` | Charge uniquement le contexte Web pour tester les contrôleurs. |
| `@MockBean` | Crée un mock d'un bean pour les tests. |
| `@DataJpaTest` | Charge uniquement le contexte JPA pour tester les repositories. |
| **Autres annotations utiles** | **Description** |
| `@Value("${config.key}")` | Injecte une valeur depuis `application.properties`. |
| `@ConditionalOnProperty(name="feature.enabled", havingValue="true")` | Active un bean si une propriété est définie. |
| `@Lazy` | Charge un bean uniquement quand il est nécessaire. |
| `@Async` | Exécute une méthode de manière asynchrone. |





## **10. Configuration avec `application.properties`**
Spring Boot utilise **un fichier de configuration unique** (`application.properties` ou `application.yml`) pour la configuration d'un projet.

ex:

```c#
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/ma_base
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
```
Ces configurations permettent de **changer le port du serveur**, **configurer la base de données**, etc.



## **11. Débogage et gestion des erreurs dans Spring Boot**

Spring Boot fournit plusieurs mécanismes pour faciliter le débogage et la gestion des erreurs.

### **A. Logs avec SLF4J et Logback**
Spring Boot utilise par défaut **SLF4J** avec **Logback** pour la gestion des logs. Il est facilement possible de personnaliser la configuration des logs dans le fichier `application.properties` ou `application.yml` :

ex:

```c#
logging.level.org.springframework.web=DEBUG
logging.level.com.example=TRACE
logging.file.name=logs/application.log
```

### **B. Gestion des erreurs via `@ControllerAdvice`**
On peut également utiliser `@ControllerAdvice` pour gérer les erreurs globales au niveau de l'application. Cela permet de centraliser le traitement des exceptions et de renvoyer des réponses appropriées à l'utilisateur.

```java
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse("RESOURCE_NOT_FOUND", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
```

### **C. Utilisation de `@ExceptionHandler` dans les Controllers**
Dans un controller, il est aussi possible d'ajouter des méthodes spécifiques pour gérer des erreurs particulières.

```java
@RestController
public class UserController {
    
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse("RESOURCE_NOT_FOUND", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
```

### **D. Actuator pour surveiller l'application**
Spring Boot Actuator offre une vue détaillée de l'état de l'application et permet de monitorer divers aspects comme les métriques, la santé de l'application, les threads, etc. On peut l'activer dans le `pom.xml`.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Une fois cela fait, on peut accéder à des points de surveillance comme :
- `/actuator/health` pour vérifier l'état de santé de l'application.
- `/actuator/metrics` pour des métriques sur les performances de l'application.



## **12. Gestion de l'authentification avec JWT et Keycloak**

L'authentification basée sur **JWT (JSON Web Token)** est une méthode populaire pour sécuriser les API, permettant aux utilisateurs de se connecter une fois et d'accéder à des ressources sécurisées sans avoir à se réauthentifier.

**Keycloak** est une solution de gestion d'identité et d'accès (IAM) qui peut être utilisée pour implémenter l'authentification et l'autorisation dans une application Spring Boot avec JWT.



## **13. Documentation API avec Swagger**

**Swagger** est un outil populaire pour générer de la documentation pour les API REST. Il permet de fournir une interface interactive pour tester les API. Dans une application Spring Boot, on peut l'intégrer facilement à l'aide de la bibliothèque **Springfox** ou **Springdoc OpenAPI**.

#### **1. Intégration de Swagger avec Spring Boot**

Voici comment intégrer Swagger dans un projet Spring Boot à l’aide de **Springdoc OpenAPI** (une alternative moderne et simplifiée à Springfox).

##### **1.1 Ajout des dépendances**

Dans `pom.xml`, ajoutez la dépendance suivante pour Springdoc OpenAPI :

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.6.10</version>
</dependency>
```

##### **1.2 Configuration de Swagger**

Ajoutez une configuration pour Swagger dans une classe de configuration Spring :

```java
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Mon API REST").version("1.0")
                .description("Documentation de l'API REST de mon application"));
    }
}
```

##### **1.3 Accéder à la Documentation Swagger**

Une fois la configuration effectuée, lancez votre application Spring Boot et accédez à l'interface Swagger UI via l'URL suivante :

```
http://localhost:8080/swagger-ui/index.html
```

Cela vous permettra de visualiser toutes les routes disponibles, d'envoyer des requêtes et de voir les réponses directement depuis l'interface web.

#### **2. Personnalisation de la Documentation API**

Il est possible d'enrichir la documentation avec des annotations Swagger pour personnaliser le comportement de l'API.

Exemples d'annotations courantes :

- `@Operation`: Décrit l'opération d'un endpoint.
- `@Parameter`: Ajoute des détails sur les paramètres d'entrée.
- `@ApiResponse`: Décrit les réponses possibles d'un endpoint.

Exemple d'annotation pour un endpoint :

```java
@Operation(summary = "Récupérer tous les utilisateurs", description = "Cette API permet de récupérer la liste de tous les utilisateurs.")
@GetMapping("/users")
public List<User> getUsers() {
    return userService.getAllUsers();
}
```

Cela ajoute des informations supplémentaires à la documentation générée, améliorant ainsi l'expérience pour les développeurs qui consomment l'API.


