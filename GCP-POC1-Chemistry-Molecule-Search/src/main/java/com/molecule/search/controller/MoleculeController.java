package com.molecule.search.controller;

import com.molecule.search.model.MoleculeStructure;
import com.molecule.search.service.MoleculeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/molecule")
public class MoleculeController {

    private final MoleculeService moleculeService;

    public MoleculeController(MoleculeService moleculeService) {
        this.moleculeService = moleculeService;
    }

    @GetMapping(value = "SearchAll")
    public ResponseEntity<List<MoleculeStructure>> getAllCompounds(){
        List<MoleculeStructure> data=moleculeService.searchAll();
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @GetMapping(value = "subStructure")
    public ResponseEntity<List<MoleculeStructure>> getSubStructureSearch(@RequestParam(value="sub_smiles_mol") String sub_smiles_mol) {
        List<MoleculeStructure> data=moleculeService.subStructure(sub_smiles_mol);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("fullFragment")
    public ResponseEntity<List<MoleculeStructure>> getFullFragmentSearch(@RequestParam (value="sub_smiles_mol") String sub_smiles_mol) {
        List<MoleculeStructure>data=moleculeService.fullFragment(sub_smiles_mol);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @GetMapping("superStructure")
    public ResponseEntity<List<MoleculeStructure>> getSuperStructureSearch(@RequestParam (value="sub_smiles_mol") String sub_smiles_mol) {
        List<MoleculeStructure>data=moleculeService.superStructure(sub_smiles_mol);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @GetMapping("duplicate")
    public ResponseEntity<List<MoleculeStructure>> getDuplicateSearch(@RequestParam (value="sub_smiles_mol") String sub_smiles_mol) {
        List<MoleculeStructure>data=moleculeService.duplicate(sub_smiles_mol);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @GetMapping("similarity")
    public ResponseEntity<List<MoleculeStructure>> getSimilaritySearch(@RequestParam (value="sub_smiles_mol") String sub_smiles_mol,
                                                         @RequestParam (value="prefix") float prefix,
                                                         @RequestParam (value ="postfix") float postfix) {
        List<MoleculeStructure>data=moleculeService.similaritySearch(sub_smiles_mol,prefix,postfix);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
}
