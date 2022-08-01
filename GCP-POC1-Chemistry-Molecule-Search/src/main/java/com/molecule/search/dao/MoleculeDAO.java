package com.molecule.search.dao;

import com.molecule.search.model.MoleculeStructure;

import java.util.List;

public interface MoleculeDAO {
    List<MoleculeStructure> getAll();
    List<MoleculeStructure> subStructureSearch(String sub_smiles_mol);
    List<MoleculeStructure> fullFragmentSearch(String sub_smiles_mol);
    List<MoleculeStructure> superStructureSearch(String sub_smiles_mol);
    List<MoleculeStructure> duplicateSearch(String sub_smiles_mol);
    List<MoleculeStructure> similaritySearch(String sub_smiles_mol,float prefix, float postfix);
}
