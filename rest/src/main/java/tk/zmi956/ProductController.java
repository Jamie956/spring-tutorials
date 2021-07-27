package tk.zmi956;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

	@GetMapping("")
	public List<Product> findAll() {
		List<Product> ps = new ArrayList<Product>();
		ps.add(new Product("1", "cpu", "99"));
		ps.add(new Product("2", "main", "99"));
		return ps;
	}

	/**
	 * localhost:8856/product/1
	 */
	@GetMapping("/{id}")
	public Product findById(@PathVariable("id") String id) {
		System.out.println("findById => " + id);
		return new Product(id, "un", "99");
	}

	/**
	 * /product/get?id=1
	 */
	@GetMapping("/get")
	public Product getById(@RequestParam("id") String id) {
		System.out.println("getById => " + id);
		return new Product(id, "nasa", "23");
	}

	/**
	 * /product
	 */
	@PostMapping("")
	public String save(@RequestBody Product product) {
		System.out.println("save => " + product);
		return "ok";
	}

	/**
	 * /product/1
	 */
	@PutMapping("/{id}")
	public String update(@RequestBody Product product) {
		System.out.println("update => " + product);
		return "ok";
	}

	/**
	 * /product/1
	 */
	@DeleteMapping("/{id}")
	public String remove(@PathVariable("id") String id) {
		System.out.println("remove => " + id);
		return "ok";
	}
}
