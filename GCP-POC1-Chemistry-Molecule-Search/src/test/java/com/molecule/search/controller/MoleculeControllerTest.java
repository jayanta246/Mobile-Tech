package com.molecule.search.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.molecule.search.model.MoleculeStructure;
import com.molecule.search.service.MoleculeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MoleculeController.class)
class MoleculeControllerTest {

    @MockBean
    MoleculeService moleculeService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllCompounds() throws Exception {
        MoleculeStructure moleculeStructure=new MoleculeStructure(
                Long.valueOf(121490217),
                Long.valueOf(1790704),
                "Compound 8 (Page No: 3565, Table No: FIG.1)",
                "Peptide",
                "PEPTIDE",
                "C10H16N2O2",
                196.2462f,
                "8d9b578a79654bd8d5365068a33fca47db02ecd5de1c4acee3086538ff274572",
                "InChIKey=XLUAWXQORJEMBD-YUMQZZPRSA-N",
                "(3S,8aS)-3-(propan-2-yl)-octahydropyrrolo[1,2-a]piperazine-1,4-dione",
                "InChI=1S/C10H16N2O2/c1-6(2)8-10(14)12-5-3-4-7(12)9(13)11-8/h6-8H,3-5H2,1-2H3,(H,11,13)/t7-,8-/m0/s1",
                "[H][C@@]12CCCN1C(=O)[C@@]([H])(NC2=O)C(C)C",
                "[H][C@@]12CCCN1C(=O)[C@@]([H])(NC2=O)C(C)C",
                Timestamp.valueOf("2022-07-11 10:17:51.036"),
                Timestamp.valueOf("2022-07-11 10:17:51.036")
        );
        List<MoleculeStructure> data = Arrays.asList(moleculeStructure);
        Mockito.when(moleculeService.searchAll()).thenReturn(data);

        mockMvc.perform(get("/api/v1/molecule/SearchAll"))
                .andExpect(status().isOk());

    }

    @Test
    void getSubStructureSearch()throws Exception {
        MoleculeStructure moleculeStructure=new MoleculeStructure(
                Long.valueOf(121357253),
                Long.valueOf(3883038),
                "Compound 23 (Page No: 5830)",
                "Organic",
                "Tetracyclo[11.2.1.01,10.04,9]hexadecane",
                "C23H39NO3",
                377.5607f,
                "28c4e273705c3a6727e9c1a50dcb1ef92305020f28db02ecc2e43caf23771c39",
                "InChIKey=PJMUHMVDWFGJRD-BQGHSHMPSA-N",
                "ethyl (1S,5R,9S,13S,14R,15R)-15-(aminomethyl)-14-hydroxy-5,9,13-trimethyltetracyclo[11.2.1.0^{1,10}.0^{4,9}]hexadecane-5-carboxylate",
                "InChI=1S/C23H39NO3/c1-5-27-19(26)22(4)10-6-9-21(3)16(22)8-12-23-14-20(2,11-7-17(21)23)18(25)15(23)13-24/h15-18,25H,5-14,24H2,1-4H3/t15-,16?,17?,18-,20+,21-,22-,23-/m1/s1",
                "CCOC(=O)[C@]1(C)CCC[C@@]2(C)C3CC[C@@]4(C)C[C@]3(CCC12)[C@H](CN)[C@H]4O",
                "CCOC(=O)[C@]1(C)CCC[C@@]2(C)C3CC[C@@]4(C)C[C@]3(CCC12)[C@H](CN)[C@H]4O",
                Timestamp.valueOf("2022-07-11 10:17:51.036"),
                Timestamp.valueOf("2022-07-11 10:17:51.036")
        );

        List<MoleculeStructure> data = Arrays.asList(moleculeStructure);
        Mockito.when(moleculeService.subStructure(moleculeStructure.getSub_smiles_mol())).thenReturn(data);

        mockMvc.perform(get("/api/v1/molecule/subStructure")
                .param("sub_smiles_mol", moleculeStructure.getSub_smiles_mol())
        ).andExpect(status().isOk());
    }

    @Test
    void getFullFragmentSearch() throws Exception {

        MoleculeStructure moleculeStructure=new MoleculeStructure(
                Long.valueOf(121357253),
                Long.valueOf(3883038),
                "Compound 23 (Page No: 5830)",
                "Organic",
                "Tetracyclo[11.2.1.01,10.04,9]hexadecane",
                "C23H39NO3",
                377.5607f,
                "28c4e273705c3a6727e9c1a50dcb1ef92305020f28db02ecc2e43caf23771c39",
                "InChIKey=PJMUHMVDWFGJRD-BQGHSHMPSA-N",
                "ethyl (1S,5R,9S,13S,14R,15R)-15-(aminomethyl)-14-hydroxy-5,9,13-trimethyltetracyclo[11.2.1.0^{1,10}.0^{4,9}]hexadecane-5-carboxylate",
                "InChI=1S/C23H39NO3/c1-5-27-19(26)22(4)10-6-9-21(3)16(22)8-12-23-14-20(2,11-7-17(21)23)18(25)15(23)13-24/h15-18,25H,5-14,24H2,1-4H3/t15-,16?,17?,18-,20+,21-,22-,23-/m1/s1",
                "CCOC(=O)[C@]1(C)CCC[C@@]2(C)C3CC[C@@]4(C)C[C@]3(CCC12)[C@H](CN)[C@H]4O",
                "CCOC(=O)[C@]1(C)CCC[C@@]2(C)C3CC[C@@]4(C)C[C@]3(CCC12)[C@H](CN)[C@H]4O",
                Timestamp.valueOf("2022-07-11 10:17:51.036"),
                Timestamp.valueOf("2022-07-11 10:17:51.036")
        );

        List<MoleculeStructure> data = Arrays.asList(moleculeStructure);
        Mockito.when(moleculeService.fullFragment(moleculeStructure.getSub_smiles_mol())).thenReturn(data);

        mockMvc.perform(get("/api/v1/molecule/fullFragment")
                .param("sub_smiles_mol", moleculeStructure.getSub_smiles_mol())
        ).andExpect(status().isOk());
    }

    @Test
    void getSuperStructureSearch() throws Exception {

        MoleculeStructure moleculeStructure=new MoleculeStructure(
                Long.valueOf(121357253),
                Long.valueOf(3883038),
                "Compound 23 (Page No: 5830)",
                "Organic",
                "Tetracyclo[11.2.1.01,10.04,9]hexadecane",
                "C23H39NO3",
                377.5607f,
                "28c4e273705c3a6727e9c1a50dcb1ef92305020f28db02ecc2e43caf23771c39",
                "InChIKey=PJMUHMVDWFGJRD-BQGHSHMPSA-N",
                "ethyl (1S,5R,9S,13S,14R,15R)-15-(aminomethyl)-14-hydroxy-5,9,13-trimethyltetracyclo[11.2.1.0^{1,10}.0^{4,9}]hexadecane-5-carboxylate",
                "InChI=1S/C23H39NO3/c1-5-27-19(26)22(4)10-6-9-21(3)16(22)8-12-23-14-20(2,11-7-17(21)23)18(25)15(23)13-24/h15-18,25H,5-14,24H2,1-4H3/t15-,16?,17?,18-,20+,21-,22-,23-/m1/s1",
                "CCOC(=O)[C@]1(C)CCC[C@@]2(C)C3CC[C@@]4(C)C[C@]3(CCC12)[C@H](CN)[C@H]4O",
                "CCOC(=O)[C@]1(C)CCC[C@@]2(C)C3CC[C@@]4(C)C[C@]3(CCC12)[C@H](CN)[C@H]4O",
                Timestamp.valueOf("2022-07-11 10:17:51.036"),
                Timestamp.valueOf("2022-07-11 10:17:51.036")
        );

        List<MoleculeStructure> data = Arrays.asList(moleculeStructure);
        Mockito.when(moleculeService.superStructure(moleculeStructure.getSub_smiles_mol())).thenReturn(data);

        mockMvc.perform(get("/api/v1/molecule/superStructure")
                .param("sub_smiles_mol", moleculeStructure.getSub_smiles_mol())
        ).andExpect(status().isOk());

    }

    @Test
    void getDuplicateSearch() throws Exception {

        MoleculeStructure moleculeStructure=new MoleculeStructure(
                Long.valueOf(121357253),
                Long.valueOf(3883038),
                "Compound 23 (Page No: 5830)",
                "Organic",
                "Tetracyclo[11.2.1.01,10.04,9]hexadecane",
                "C23H39NO3",
                377.5607f,
                "28c4e273705c3a6727e9c1a50dcb1ef92305020f28db02ecc2e43caf23771c39",
                "InChIKey=PJMUHMVDWFGJRD-BQGHSHMPSA-N",
                "ethyl (1S,5R,9S,13S,14R,15R)-15-(aminomethyl)-14-hydroxy-5,9,13-trimethyltetracyclo[11.2.1.0^{1,10}.0^{4,9}]hexadecane-5-carboxylate",
                "InChI=1S/C23H39NO3/c1-5-27-19(26)22(4)10-6-9-21(3)16(22)8-12-23-14-20(2,11-7-17(21)23)18(25)15(23)13-24/h15-18,25H,5-14,24H2,1-4H3/t15-,16?,17?,18-,20+,21-,22-,23-/m1/s1",
                "CCOC(=O)[C@]1(C)CCC[C@@]2(C)C3CC[C@@]4(C)C[C@]3(CCC12)[C@H](CN)[C@H]4O",
                "CCOC(=O)[C@]1(C)CCC[C@@]2(C)C3CC[C@@]4(C)C[C@]3(CCC12)[C@H](CN)[C@H]4O",
                Timestamp.valueOf("2022-07-11 10:17:51.036"),
                Timestamp.valueOf("2022-07-11 10:17:51.036")
        );

        List<MoleculeStructure> data = Arrays.asList(moleculeStructure);
        Mockito.when(moleculeService.duplicate(moleculeStructure.getSub_smiles_mol())).thenReturn(data);

        mockMvc.perform(get("/api/v1/molecule/superStructure")
                .param("sub_smiles_mol", moleculeStructure.getSub_smiles_mol())
        ).andExpect(status().isOk());

    }

    @Test
    void getSimilaritySearch() throws Exception {

        MoleculeStructure moleculeStructure=new MoleculeStructure(
                Long.valueOf(121357263),
                Long.valueOf(10046),
                "Compound [Cisplatin]",
                "Organic",
                "",
                "Cl2H6N2Pt",
                300.051f,
                "6c4f420d03df8c50daaf1d496d6ad3e752d04c1c3d229165163152778bc5f2f7",
                "InChIKey=LXZZYRPGZAFOLE-UHFFFAOYSA-L",
                "dichloroplatinum diamine",
                "InChI=1S/2ClH.2H3N.Pt/h2*1H;2*1H3;/q;;;;+2/p-2",
                "Cl[Pt]Cl.[H]N([H])[H].[H]N([H])[H]",
                "Cl[Pt]Cl.[H]N([H])[H].[H]N([H])[H]",
                Timestamp.valueOf("2022-07-11 10:17:51.036"),
                Timestamp.valueOf("2022-07-11 10:17:51.036")
        );

        final float prefix=0.0f;
        final float postfix=0.56f;


        List<MoleculeStructure> data = Arrays.asList(moleculeStructure);
        Mockito.when(moleculeService.similaritySearch(moleculeStructure.getSub_smiles_mol(),prefix,postfix)).thenReturn(data);

        mockMvc.perform(get("/api/v1/molecule/similaritySearch")
                .param("sub_smiles_mol", moleculeStructure.getSub_smiles_mol())
                .requestAttr("prefix",prefix)
                .requestAttr("postfix",postfix)
        ).andExpect(status().isOk());
    }
}
