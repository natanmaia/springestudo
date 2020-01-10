package br.com.natanmaia.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.natanmaia.converter.mocks.MockPessoa;
import br.com.natanmaia.data.models.Pessoa;
import br.com.natanmaia.data.vo.PessoaVO;

public class DozerConverterTest {
	
	MockPessoa inputObject;
	
	@Before
	public void setUp() {
		inputObject = new MockPessoa();
	}
	
	@Test
	public void parseEntityToVOTest() {
		PessoaVO output = DozerConverter.parseObject(inputObject.mockEntity(), PessoaVO.class);
		Assert.assertEquals(Long.valueOf(0L), output.getId());
		Assert.assertEquals("Nome teste0", output.getNome());
		Assert.assertEquals("Sobrenome teste0", output.getSobrenome());
		Assert.assertEquals("Endereço teste0", output.getEndereco());
		Assert.assertEquals("Masculino", output.getGenero());
	}
	
	@Test
	public void parseEntityListToVOTest() {
		List<PessoaVO> outputList = DozerConverter.parseListObject(inputObject.mockEntityList(), PessoaVO.class);
		PessoaVO outputZero = outputList.get(0);
		
		Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
		Assert.assertEquals("Nome teste0", outputZero.getNome());
		Assert.assertEquals("Sobrenome teste0", outputZero.getSobrenome());
		Assert.assertEquals("Endereço teste0", outputZero.getEndereco());
		Assert.assertEquals("Masculino", outputZero.getGenero());
		
		PessoaVO outputSete = outputList.get(7);
		
		Assert.assertEquals(Long.valueOf(7L), outputSete.getId());
		Assert.assertEquals("Nome teste7", outputSete.getNome());
		Assert.assertEquals("Sobrenome teste7", outputSete.getSobrenome());
		Assert.assertEquals("Endereço teste7", outputSete.getEndereco());
		Assert.assertEquals("Feminino", outputSete.getGenero());
		
		PessoaVO outputDoze = outputList.get(12);
		
		Assert.assertEquals(Long.valueOf(12L), outputDoze.getId());
		Assert.assertEquals("Nome teste12", outputDoze.getNome());
		Assert.assertEquals("Sobrenome teste12", outputDoze.getSobrenome());
		Assert.assertEquals("Endereço teste12", outputDoze.getEndereco());
		Assert.assertEquals("Masculino", outputDoze.getGenero());
	}
	
	@Test
	public void parseVOToEntityTest() {
		Pessoa output = DozerConverter.parseObject(inputObject.mockEntity(), Pessoa.class);
		Assert.assertEquals(Long.valueOf(0L), output.getId());
		Assert.assertEquals("Nome teste0", output.getNome());
		Assert.assertEquals("Sobrenome teste0", output.getSobrenome());
		Assert.assertEquals("Endereço teste0", output.getEndereco());
		Assert.assertEquals("Masculino", output.getGenero());
	}
	
	@Test
	public void parseVOListToEntityListTest() {
		List<Pessoa> outputList = DozerConverter.parseListObject(inputObject.mockEntityList(), Pessoa.class);
		Pessoa outputZero = outputList.get(0);
		
		Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
		Assert.assertEquals("Nome teste0", outputZero.getNome());
		Assert.assertEquals("Sobrenome teste0", outputZero.getSobrenome());
		Assert.assertEquals("Endereço teste0", outputZero.getEndereco());
		Assert.assertEquals("Masculino", outputZero.getGenero());
		
		Pessoa outputSete = outputList.get(7);
		
		Assert.assertEquals(Long.valueOf(7L), outputSete.getId());
		Assert.assertEquals("Nome teste7", outputSete.getNome());
		Assert.assertEquals("Sobrenome teste7", outputSete.getSobrenome());
		Assert.assertEquals("Endereço teste7", outputSete.getEndereco());
		Assert.assertEquals("Feminino", outputSete.getGenero());
		
		Pessoa outputDoze = outputList.get(12);
		
		Assert.assertEquals(Long.valueOf(12L), outputDoze.getId());
		Assert.assertEquals("Nome teste12", outputDoze.getNome());
		Assert.assertEquals("Sobrenome teste12", outputDoze.getSobrenome());
		Assert.assertEquals("Endereço teste12", outputDoze.getEndereco());
		Assert.assertEquals("Masculino", outputDoze.getGenero());
	}
}
