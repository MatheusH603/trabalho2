package dw.secauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import dw.secauth.model.Artigo;
import dw.secauth.repository.ArtigoRepository;

@RestController
//@RequestMapping("/api")
public class ArtigoController {

    @Autowired
    ArtigoRepository rep;
    

    /*@GetMapping("/listarTodos")
    public  ResponseEntity<List<Artigo>> getAllArtigos(@RequestParam(required = false) String titulo)
    {
        try
        {
            List<Artigo> la = new ArrayList<Artigo>();

            if (titulo == null)
                rep.findAll().forEach(la::add);
            else
                rep.findByTituloContaining(titulo).forEach(la::add);

            if (la.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
            return new ResponseEntity<>(la, HttpStatus.OK);
            


        }
         catch (Exception e) {
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }*/
     
    @PostMapping("/cadastrarArtigo")
    public ResponseEntity<Artigo> createArtigo(Artigo ar)
    {   
        try {
            Artigo _a = rep.save(new Artigo(ar.getTitulo(), ar.getResumo(), ar.isPublicado()));

            return new ResponseEntity<>(_a, HttpStatus.CREATED);
            
        } catch (Exception e) {
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
     /*
    @GetMapping("/listarId/{id}")
    public ResponseEntity<Artigo> getArtigoById(@PathVariable("id") long id)
    {
        Optional<Artigo> data = rep.findById(id);

        if (data.isPresent())
            return new ResponseEntity<>(data.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }*/

     /*
    @PutMapping("/artigos/{id}")
    public ResponseEntity<Artigo> updateArtigo(@PathVariable("id") long id, @RequestBody Artigo a)
    {
        Optional<Artigo> data = rep.findById(id);

        if (data.isPresent())
        {
            Artigo ar = data.get();
            ar.setPublicado(a.isPublicado());
            ar.setResumo(a.getResumo());
            ar.setTitulo(a.getTitulo());

            return new ResponseEntity<>(rep.save(ar), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }*/
    /*
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<HttpStatus> deleteArtigo(@PathVariable("id") long id)
    {
        try {
            rep.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        } catch (Exception e) {
            
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

     */
    /*@DeleteMapping("/deletar")
    public ResponseEntity<HttpStatus> deleteAllArtigo()
    {
        try {
            rep.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        } catch (Exception e) {
            
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }*/

   
    @GetMapping("/listarTudo")
    public ModelAndView getArtigos() {
        ModelAndView mv = new ModelAndView("listar/listar");
        List<Artigo> listar = rep.findAll();
        mv.addObject("listar", listar);
        return mv; 
    }
    
    @GetMapping("/excluir/{id}")
    public String excluirArtigos(@PathVariable(value="id") long id){
        
        Artigo art = rep.findArtigoById(id);
        rep.delete(art);
        return "Artigo Excluido!";
    }

    @GetMapping("/excluirTodos")
    public String excluirTodos(){       
        rep.deleteAll();
        return "Todos os Artigos foram excluidos!";
    }
    

}

   
    



