package com.molecule.search.service;

import com.molecule.search.dao.MoleculeDAO;
import com.molecule.search.model.MoleculeStructure;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoleculeService {

    private final MoleculeDAO moleculeDAO;

    public MoleculeService(MoleculeDAO moleculeDAO) {
        this.moleculeDAO = moleculeDAO;
    }

    public List<MoleculeStructure>searchAll(){
        return moleculeDAO.getAll();
    }
    public List<MoleculeStructure>subStructure(String sub_smiles_mol) {
        return moleculeDAO.subStructureSearch(sub_smiles_mol);
    }

    public  List<MoleculeStructure>fullFragment(String sub_smiles_mol){
        return moleculeDAO.fullFragmentSearch(sub_smiles_mol);
    }

    public  List<MoleculeStructure>superStructure(String sub_smiles_mol){
        return moleculeDAO.superStructureSearch(sub_smiles_mol);
    }

    public List<MoleculeStructure>duplicate(String sub_smiles_mol){
        return moleculeDAO.duplicateSearch(sub_smiles_mol);
    }

    public List<MoleculeStructure> similaritySearch(String sub_smiles_mol, float prefix, float postfix){
        return moleculeDAO.similaritySearch(sub_smiles_mol, prefix, postfix);
    }


}
