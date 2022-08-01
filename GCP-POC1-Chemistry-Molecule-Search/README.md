




# **Project Description:**
## Requirement:
1. API - Sub Structure Search
2. API - Full Fragment Search
3. API - Super Structure Search
4. API - Duplicate Search
5. API - Similarity Search


### Setting up the Project:  
1. Spring Web
2. PostgreSQL Driver
3. JDBC API
4. spring Data JDBC
5. spring Security


### Query Implementations:

##### 1. Sub Structure Search -

String sql = "select * from structure_details where " + "'"+sub_smiles_mol +"'"+ "::Molecule('sample')|<|sub_smiles_mol";

##### 2. Full Fragment Search -

String sql="SELECT * FROM structure_details WHERE query_transform("+"'"+sub_smiles_mol+"'"+"::Molecule('sample'), 'ignoretetrahedralstereo') |<| sub_smiles_mol";

##### 3. Super Structure Search -

String sql = "select * from structure_details where " + "'"+sub_smiles_mol +"'"+ "::Molecule('sample')|>|sub_smiles_mol";

##### 4. Duplicate Search -

String sql = "SELECT * FROM structure_details WHERE " + "'" + sub_smiles_mol + "'" + "::Molecule('sample')|=|sub_smiles_mol";

##### 5. Similarity Search -

select s.gvk_id,s.str_id,s.mol_formula,s.sub_smiles_mol,s.compound_names,s.compound_type,s.derivatives,s.mol_weight,s.inchi,s.inchikey,s.iupac_name,s.iupac_inchi,s.sub_smiles,s.sub_smiles_mol |~| qs.query_smiles sim_per
from structure_details s,(select 'C1=CC=C(C=C1)C1=C(C=CC=C1)C1=CC=CC=C1'::molecule('sample') query_smiles) qs
where row(qs.query_smiles, 0.0)::sim_filter |~>| s.sub_smiles_mol
and s.sub_smiles_mol |~| qs.query_smiles between 0.0 and 0.56;



### API's EndPoints:
1. Sub Structure Search - http://localhost:8080/api/v1/molecule/subStructure?sub_smiles_mol=C1CCCCC1
2. Full Fragment Search - http://localhost:8080/api/v1/molecule/fullFragment?sub_smiles_mol=C1CCCCC1
3. Super Structure Search - http://localhost:8080/api/v1/molecule/superStructure?sub_smiles_mol=C1CCCCC1
4. Duplicate Search - http://localhost:8080/api/v1/molecule/duplicate?sub_smiles_mol=CCCC
5. Similarity Search - http://localhost:8080/api/v1/molecule/similarity?sub_smiles_mol=C1=CC=C(C=C1)C1=C(C=CC=C1)C1=CC=CC=C1&prefix=0.0&postfix=0.56


### Psql Query's:

##### 1. Sub Structure Search -

SELECT * FROM structure_details WHERE 'C1CCCCC1'::Molecule('sample') |<| sub_smiles_mol;

##### 2. Full Fragment Search -

SELECT * FROM structure_details WHERE query_transform('C1CCCCC1'::Molecule('sample'), 'ignoretetrahedralstereo') |<| sub_smiles_mol;

##### 3. Super Structure Search -

SELECT * FROM structure_details WHERE 'C1CCCCC1'::Molecule('sample') |>| sub_smiles_mol;

##### 4. Duplicate Search -

SELECT * FROM structure_details WHERE 'C1CCCCC1'::Molecule('sample') |=| sub_smiles_mol;

##### 5. Similarity Search -

SELECT s.gvk_id,s.str_id,s.mol_formula,s.sub_smiles_mol |~| qs.query_smiles sim_per from structure_details s,(select 'C1=CC=C(C=C1)C1=C(C=CC=C1)C1=CC=CC=C1'::molecule('sample') query_smiles) qs
where row(qs.query_smiles, 0.0)::sim_filter |~>| s.sub_smiles_mol and s.sub_smiles_mol |~| qs.query_smiles between 0.0 and 0.56;

## Package and Class Structure:

#### controller -> MoleculeController
This class is responsible for processing incoming REST API requests, preparing a model, and returning the view to be rendered as a response.
This class annotated with @RestController

#### dao -> MoleculeDAO
this is a Data Access Object interface which contain the Search API's methods
This class is responsible to get data from a data source

#### exception -> 
This class handle the exceptions

#### Model -> MoleculeStructure
This is Entity class this class map the table in the database

#### repository -> MoleculerDataAccess
this class annotated with @Repository
this class implements the sql queries.
#### repository -> MoleculeRowMapper
this is a row mapper class is used to fetch the records from the database using the query() method.
and maps the row of relations with the instances to the model
RowMapper class get an object from database and map each row of the 
resultset with the instence of the model class

#### service -> MoleculeService
This is a service class annotated with @Service. These class files are used to write business logic in a different layer, separated from @RestController class file