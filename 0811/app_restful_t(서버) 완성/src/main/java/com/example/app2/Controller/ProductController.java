package com.example.app2.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app2.model.member.MemberVO;
import com.example.app2.model.product.Product;
import com.example.app2.model.product.ProductFile;
import com.example.app2.model.product.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
	@Autowired
	private ProductService service;

	//create: product 객체 생성하여 추가
	@PostMapping("/products")
	public Map add(ProductFile pf) {
		System.out.println(pf);
		service.addProduct(pf);
		String seller = pf.getP().getSeller().getId();
		System.out.println(pf.getP());
		Map map = new HashMap();
		map.put("action", "product create");
		map.put("result", true);
		return map;
	}

	//get: 제품 상세정보 검색
	@GetMapping("/products/{num}")
	public Map details(@PathVariable("num") int num) {
		String result = "";
		Product p = service.getByNum(num);
		Map map = new HashMap();
		map.put("action", "product get");
		map.put("result", p!=null);
		map.put("data", p);
		return map;
	}
	
	//get: 모든 제품 검색
	@GetMapping("/products")
	public Map listall(Model m) {
		List<Product> list = service.getAll();
		System.out.println("get product 함수 진입. 현재 제품목록 출력");
		for(Product p:list){
			System.out.println(p);
		}
		Map map = new HashMap();
		map.put("action", "product get");
		map.put("result", true);
		map.put("data", list);
		return map;
	}

	//구매자: 상품 이름으로 검색
	@GetMapping("/products/items/{name}")
	public Map listbyname(@PathVariable("name") String name) {
		List<Product> list = service.getByName("%" + name + "%");
		Map map = new HashMap();
		map.put("action", "product get");
		map.put("result", true);
		map.put("data", list);
		return map;
	}
	
	//구매자: 판매자명으로 검색
	@GetMapping("/products/itemsby/{seller}")
	public Map listbyseller(@PathVariable("seller") String seller) {
		MemberVO m = new MemberVO();
		m.setId(seller);
		boolean result = false;
		Map map = new HashMap();
		map.put("action", "product getby seller");
		if (m != null) {
			result = true;
			List<Product> list = service.getBySeller(m);
			map.put("data", list);
		}
		map.put("result", result);
		return map;
	}

	
	//판매자: 상품 수정
	@PutMapping("/products/")
	public Map edit(Product p) {
		service.editProduct(p);
		Map map = new HashMap();
		map.put("action", "product edit");
		map.put("result", true);
		return map;
	}

	//판매자: 상품 삭제
	@DeleteMapping("/products/{num}")
	public Map del(@PathVariable("num") int num) {
		service.delProduct(num);
		Map map = new HashMap();
		map.put("action", "product edit");
		map.put("result", true);
		return map;
	}	
}
