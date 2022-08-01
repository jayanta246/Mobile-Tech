package com.molecule.search.repository;

import com.molecule.search.dao.MoleculeDAO;
import com.molecule.search.exception.ApiRequestException;
import com.molecule.search.model.MoleculeStructure;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MoleculeDataAccess implements MoleculeDAO {

    private final JdbcTemplate jdbcTemplate;

    public MoleculeDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MoleculeStructure> getAll() {
        String sql = "select compound_names, sub_smiles_mol from structure_details";
        List<MoleculeStructure> getAllResult=jdbcTemplate.query(sql,new BeanPropertyRowMapper<MoleculeStructure>(MoleculeStructure.class));
        if(getAllResult.isEmpty()){
            throw new ApiRequestException("NOT DATA FOUND - No Data Found in The DataBase Please Check The Input Again");
        }
        return getAllResult;
    }

    @Override
    public List<MoleculeStructure> subStructureSearch(String sub_smiles_mol) {
        String sql = "select * from structure_details where " + "'"+sub_smiles_mol +"'"+ "::Molecule('sample')|<|sub_smiles_mol";
        List<MoleculeStructure> subStructureSearchResult=jdbcTemplate.query(sql,new MoleculeRowMapper());
        if(subStructureSearchResult.isEmpty()){
            throw new ApiRequestException("NOT DATA FOUND - No Data Found in The DataBase Please Check The Input Again");
        }
        return subStructureSearchResult;
    }

    @Override
    public List<MoleculeStructure> fullFragmentSearch(String sub_smiles_mol) {
        String sql="SELECT * FROM structure_details WHERE query_transform("+"'"+sub_smiles_mol+"'"+"::Molecule('sample'), 'ignoretetrahedralstereo') |<| sub_smiles_mol";
        List<MoleculeStructure>fullFragmentSearchResult=jdbcTemplate.query(sql,new MoleculeRowMapper());
        if(fullFragmentSearchResult.isEmpty()){
            throw new ApiRequestException("NOT DATA FOUND - No Data Found in The DataBase Please Check The Input Again");
        }
        return fullFragmentSearchResult;
    }

    @Override
    public List<MoleculeStructure> superStructureSearch(String sub_smiles_mol) {
        String sql = "select * from structure_details where " + "'"+sub_smiles_mol +"'"+ "::Molecule('sample')|>|sub_smiles_mol";
        List<MoleculeStructure>superStructureSearchResult=jdbcTemplate.query(sql,new MoleculeRowMapper());
        if(superStructureSearchResult.isEmpty()){
            throw new ApiRequestException("NOT DATA FOUND - No Data Found in The DataBase Please Check The Input Again");
        }
        return superStructureSearchResult;
    }

    @Override
    public List<MoleculeStructure> duplicateSearch(String sub_smiles_mol) {
        String sql = "SELECT * FROM structure_details WHERE " + "'" + sub_smiles_mol + "'" + "::Molecule('sample')|=|sub_smiles_mol";
        List<MoleculeStructure>duplicateSearchResult=jdbcTemplate.query(sql,new MoleculeRowMapper());
        if(duplicateSearchResult.isEmpty()){
            throw new ApiRequestException("NOT DATA FOUND - No Data Found in The DataBase Please Check The Input Again");
        }
        return duplicateSearchResult;
    }

    @Override
    public List<MoleculeStructure> similaritySearch(String sub_smiles_mol, float prefix, float postfix) {
        String sql="select gvk_id,str_id,mol_formula,sub_smiles_mol |~| qs.query_smiles sim_per from structure_details,(select " + "'" + sub_smiles_mol + "'" + "::molecule('sample') query_smiles) qs where row(qs.query_smiles, 0.0)::sim_filter |~>| sub_smiles_mol and sub_smiles_mol |~| qs.query_smiles between 0.0 and 0.56";
        List<MoleculeStructure>similaritySearchResult=jdbcTemplate.query(sql,new BeanPropertyRowMapper<MoleculeStructure>(MoleculeStructure.class));
        if(similaritySearchResult.isEmpty()){
            throw new ApiRequestException("NOT DATA FOUND - No Data Found in The DataBase Please Check The Input Again");
        }
        return similaritySearchResult;
    }
}
