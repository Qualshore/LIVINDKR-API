package qualshore.livindkr.main.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qualshore.livindkr.main.entities.Article;
import qualshore.livindkr.main.repository.ArticlesRepository;

@RequestMapping("/articles")
@RestController
public class ArticlesControllers {
	
	@Autowired
	private ArticlesRepository articlesrepository;
	
	
	@RequestMapping(value="/list_articles", method=RequestMethod.GET)
	public HashMap<String, Object> getAllArticles(){
		
		HashMap<String, Object> h= new HashMap<String, Object>();
		
		List<Article> article = articlesrepository.findAll();
		
		if (article.size() == 0) {
			
			h.put("message", "Il n'y a pas d'articles.");
			h.put("status", -1);
			return h;
			
		}else {
			
			h.put("message", "La liste des articles sont :");
			h.put("article", article);
			h.put("status", 0);
			return h;
			
		}
		
		
	}

}
