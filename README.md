# jmoordbproducer
proyecto para testing de producer

CLASES
### XMongoConnection tiene el producer 
 @Produces
    @ApplicationScoped
    public MongoClient mongoClient() {
        String username =(String) JmoordbContextApplication.get("username");
        String password =(String)JmoordbContextApplication.get("password");
        MongoClient mongo = new MongoClient("localhost", 27017);
        return mongo;
    } 

Esto permite que desde cualquier lugar donde se invoce mediante un inject
@Inject
MongoClient mongoClient;
-->El llamara al producer
-->Esta definido como @Singleton lo que garantiza que solo lo hara una vez
-->Esto permite que se conecte una vez 
-->Siempre devolvera la conexion a MongoDB
-->Lo pasamos en el ContextoApplication que no se pierda o pude ser un session


##PROYECTO WEB
-->Debe invocar en el algun momento y espeficar los parametros de conexion
-->Estos solo se usaran la primera vez
-->Se puede crear una clase con un build
-->En este caso la clase que se ejecuta la primera vez es el LoginController
-->Alli lo colocamos en el init() 
-->Para que sea lo primero que se realice y sirva de base a los repository
@PostConstruct
    public void init() {
        JmoordbContextApplication.put("username", "avbravo");
        JmoordbContextApplication.put("password", "password");       
    }


---------------------------------------------------
-->Eliminar el MongoClientProvider del proyecto ejb
----------------------------------------
-->Eliminar  de cada repository
@EJB
    MongoClientStoreejbProvider mongoClientStoreejbProvider;
    @Override
    protected MongoClient getMongoClient() {
       return mongoClientStoreejbProvider.getMongoClient();
    }
-------------------------------------------------------------
--->Crear un constructor de tipo build llamado JmoordbConnection
para los parametros de coneccion (username, host,password), etc.
-----------------------------------------------------------
--->Crear en jmoordb: JmoordbProducer que es singleton
agregarle
------------->Agregarle
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
----------------------------------------------------
En el Repository principal
usar @Inject
MongoClient mongoclient; --> el invoca del @Producer