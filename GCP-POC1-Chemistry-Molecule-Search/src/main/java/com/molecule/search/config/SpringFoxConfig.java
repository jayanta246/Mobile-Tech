package com.molecule.search.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .host("http://localhost:8080/api/v1/molecule")
                .apiInfo(getInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.molecule.search.controller"))
                .paths(regex("/api/v1/molecule.*"))
                .build();

    }

    private ApiInfo getInfo() {
        return new ApiInfoBuilder().title("GCP-POC1-Chemistry Molecule Search")
                .description("Project Description:\n\n" +
                        "Requirement:\n\n" +
                        "API - Sub Structure Search\n" +
                        "API - Full Fragment Search\n" +
                        "API - Super Structure Search\n" +
                        "API - Duplicate Search\n" +
                        "API - Similarity Search\n\n" +
                        "Setting up the Project:\n\n" +
                        "Spring Web\n" +
                        "PostgreSQL Driver\n" +
                        "JDBC API\n" +
                        "spring Data JDBC\n" +
                        "spring Security\n\n" +
                        "API's EndPoints:\n\n" +
                        "Sub Structure Search - http://localhost:8080/api/v1/molecule/subStructure?sub_smiles_mol=C1CCCCC1\n" +
                        "Full Fragment Search - http://localhost:8080/api/v1/molecule/fullFragment?sub_smiles_mol=C1CCCCC1\n" +
                        "Super Structure Search - http://localhost:8080/api/v1/molecule/superStructure?sub_smiles_mol=C1CCCCC1\n" +
                        "Duplicate Search - http://localhost:8080/api/v1/molecule/duplicate?sub_smiles_mol=CCCC\n" +
                        "Similarity Search - http://localhost:8080/api/v1/molecule/similarity?sub_smiles_mol=C1=CC=C(C=C1)C1=C(C=CC=C1)C1=CC=CC=C1&prefix=0.0&postfix=0.56\n\n" +
                        "Psql Query's:\n\n" +
                        "1. Sub Structure Search -\n" +
                        "SELECT * FROM structure_details WHERE 'C1CCCCC1'::Molecule('sample') |<| sub_smiles_mol;\n" +
                        "\n" +
                        "2. Full Fragment Search -\n" +
                        "SELECT * FROM structure_details WHERE query_transform('C1CCCCC1'::Molecule('sample'), 'ignoretetrahedralstereo') |<| sub_smiles_mol;\n" +
                        "\n" +
                        "3. Super Structure Search -\n" +
                        "SELECT * FROM structure_details WHERE 'C1CCCCC1'::Molecule('sample') |>| sub_smiles_mol;\n" +
                        "\n" +
                        "4. Duplicate Search -\n" +
                        "SELECT * FROM structure_details WHERE 'C1CCCCC1'::Molecule('sample') |=| sub_smiles_mol;\n" +
                        "\n" +
                        "5. Similarity Search -\n" +
                        "SELECT s.gvk_id,s.str_id,s.mol_formula,s.sub_smiles_mol |~| qs.query_smiles sim_per from structure_details s,(select 'C1=CC=C(C=C1)C1=C(C=CC=C1)C1=CC=CC=C1'::molecule('sample') query_smiles) qs where row(qs.query_smiles, 0.0)::sim_filter |~>| s.sub_smiles_mol and s.sub_smiles_mol |~| qs.query_smiles between 0.0 and 0.56;\n")
                .version("1.0.0")
                .build();
    }
}
