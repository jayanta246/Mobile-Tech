package com.molecule.search.model;

import java.sql.Timestamp;

public class MoleculeStructure {
    private Long gvk_id;
    private Long str_id;
    private String compound_names;
    private String Compound_type;
    private String derivatives;
    private String mol_formula;
    private float mol_weight;
    private String inchi;
    private String inchikey;
    private String iupac_name;
    private String iupac_inchi;
    private String sub_smiles;
    private String sub_smiles_mol;
    private Timestamp created_on;
    private Timestamp modified_on;

    public MoleculeStructure(){}

    public MoleculeStructure(Long gvk_id, Long str_id, String compound_names, String compound_type, String derivatives, String mol_formula, float mol_weight, String inchi, String inchikey, String iupac_name, String iupac_inchi, String sub_smiles, String sub_smiles_mol, Timestamp created_on, Timestamp modified_on) {
        this.gvk_id = gvk_id;
        this.str_id = str_id;
        this.compound_names = compound_names;
        Compound_type = compound_type;
        this.derivatives = derivatives;
        this.mol_formula = mol_formula;
        this.mol_weight = mol_weight;
        this.inchi = inchi;
        this.inchikey = inchikey;
        this.iupac_name = iupac_name;
        this.iupac_inchi = iupac_inchi;
        this.sub_smiles = sub_smiles;
        this.sub_smiles_mol = sub_smiles_mol;
        this.created_on = created_on;
        this.modified_on = modified_on;
    }

    public Long getGvk_id() {
        return gvk_id;
    }

    public void setGvk_id(Long gvk_id) {
        this.gvk_id = gvk_id;
    }

    public Long getStr_id() {
        return str_id;
    }

    public void setStr_id(Long str_id) {
        this.str_id = str_id;
    }

    public String getCompound_names() {
        return compound_names;
    }

    public void setCompound_names(String compound_names) {
        this.compound_names = compound_names;
    }

    public String getCompound_type() {
        return Compound_type;
    }

    public void setCompound_type(String compound_type) {
        Compound_type = compound_type;
    }

    public String getDerivatives() {
        return derivatives;
    }

    public void setDerivatives(String derivatives) {
        this.derivatives = derivatives;
    }

    public String getMol_formula() {
        return mol_formula;
    }

    public void setMol_formula(String mol_formula) {
        this.mol_formula = mol_formula;
    }

    public float getMol_weight() {
        return mol_weight;
    }

    public void setMol_weight(float mol_weight) {
        this.mol_weight = mol_weight;
    }

    public String getInchi() {
        return inchi;
    }

    public void setInchi(String inchi) {
        this.inchi = inchi;
    }

    public String getInchikey() {
        return inchikey;
    }

    public void setInchikey(String inchikey) {
        this.inchikey = inchikey;
    }

    public String getIupac_name() {
        return iupac_name;
    }

    public void setIupac_name(String iupac_name) {
        this.iupac_name = iupac_name;
    }

    public String getIupac_inchi() {
        return iupac_inchi;
    }

    public void setIupac_inchi(String iupac_inchi) {
        this.iupac_inchi = iupac_inchi;
    }

    public String getSub_smiles() {
        return sub_smiles;
    }

    public void setSub_smiles(String sub_smiles) {
        this.sub_smiles = sub_smiles;
    }

    public String getSub_smiles_mol() {
        return sub_smiles_mol;
    }

    public void setSub_smiles_mol(String sub_smiles_mol) {
        this.sub_smiles_mol = sub_smiles_mol;
    }

    public Timestamp getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Timestamp created_on) {
        this.created_on = created_on;
    }

    public Timestamp getModified_on() {
        return modified_on;
    }

    public void setModified_on(Timestamp modified_on) {
        this.modified_on = modified_on;
    }

    @Override
    public String toString() {
        return "MoleculeStructure{" +
                "gvk_id=" + gvk_id +
                ", str_id=" + str_id +
                ", compound_names='" + compound_names + '\'' +
                ", Compound_type='" + Compound_type + '\'' +
                ", derivatives='" + derivatives + '\'' +
                ", mol_formula='" + mol_formula + '\'' +
                ", mol_weight=" + mol_weight +
                ", inchi='" + inchi + '\'' +
                ", inchikey='" + inchikey + '\'' +
                ", iupac_name='" + iupac_name + '\'' +
                ", iupac_inchi='" + iupac_inchi + '\'' +
                ", sub_smiles='" + sub_smiles + '\'' +
                ", sub_smiles_mol='" + sub_smiles_mol + '\'' +
                ", created_on=" + created_on +
                ", modified_on=" + modified_on +
                '}';
    }
}
