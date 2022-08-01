package com.molecule.search.repository;

import com.molecule.search.model.MoleculeStructure;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MoleculeRowMapper implements RowMapper<MoleculeStructure> {
    @Override
    public MoleculeStructure mapRow(ResultSet resultSet,int i) throws SQLException {
        MoleculeStructure moleculeStructure=new MoleculeStructure();
        moleculeStructure.setGvk_id(resultSet.getLong("gvk_id"));
        moleculeStructure.setStr_id(resultSet.getLong("str_id"));
        moleculeStructure.setCompound_names(resultSet.getString("compound_names"));
        moleculeStructure.setCompound_type(resultSet.getString("compound_type"));
        moleculeStructure.setDerivatives(resultSet.getString("derivatives"));
        moleculeStructure.setMol_formula(resultSet.getString("mol_formula"));
        moleculeStructure.setMol_weight(resultSet.getFloat("mol_weight"));
        moleculeStructure.setInchi(resultSet.getString("inchi"));
        moleculeStructure.setInchikey(resultSet.getString("inchikey"));
        moleculeStructure.setIupac_name(resultSet.getString("iupac_name"));
        moleculeStructure.setIupac_inchi(resultSet.getString("iupac_inchi"));
        moleculeStructure.setSub_smiles(resultSet.getString("sub_smiles"));
        moleculeStructure.setSub_smiles_mol(resultSet.getString("sub_smiles_mol"));
        moleculeStructure.setCreated_on(resultSet.getTimestamp("created_on"));
        moleculeStructure.setModified_on(resultSet.getTimestamp("modified_on"));
        return moleculeStructure;

    }
}
