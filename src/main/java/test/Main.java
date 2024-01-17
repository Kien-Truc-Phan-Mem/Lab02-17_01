package test;

import java.io.FileInputStream;
import java.util.List;
import java.util.Optional;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

public class Main {

	public static void main(String[] args) throws Exception {
		ParseResult<CompilationUnit> parseResult = null;
		FileInputStream fileInputStream = new FileInputStream(
				"D:\\Data_Hiep\\Nam4_ki2\\KienTruc\\Project_Code\\kientruc\\src\\main\\java\\entity\\User.java");
		try {
			JavaParser javaParser = new JavaParser();
			parseResult = javaParser.parse(fileInputStream);
			Optional<CompilationUnit> optional = parseResult.getResult();
			if(optional.isPresent())
			{
				CompilationUnit cu = optional.get();
				compileFiled(cu);
				System.out.println("=====================================");
				compileMethod(cu);
				System.out.println("=====================================");
				compileParameter(cu);
				
			}
		} finally {
			// TODO: handle finally clause
		}

	}

	public static void compileFiled(CompilationUnit cu) throws Exception {
		List<FieldDeclaration> list = cu.findAll(FieldDeclaration.class);
		for (FieldDeclaration fieldDeclaration : list) {
			System.out.println(fieldDeclaration);
		}
	}
	// compile method
	public static void compileMethod(CompilationUnit cu) throws Exception {
		List<MethodDeclaration> list = cu.findAll(MethodDeclaration.class);
		for (MethodDeclaration methodDeclaration : list) {
			System.out.println(methodDeclaration.getName());
		}
	}
	// compile parameter of method
	public static void compileParameter(CompilationUnit cu) throws Exception {
		//lấy tất cả các parameter của method
		List<MethodDeclaration> list = cu.findAll(MethodDeclaration.class);
		for (MethodDeclaration methodDeclaration : list) {
			System.out.println(methodDeclaration.getParameters());
		}
		
	}
	
	public static void scanAllJavaFile() throws Exception {
		
	}
}
