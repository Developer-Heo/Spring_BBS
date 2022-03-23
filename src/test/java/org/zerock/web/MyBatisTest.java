package org.zerock.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
// 두 애노테이션은 테스트 진행시 스프링이 로딩
// locations 경로 xml 파일을 이용해서 스프링 로딩됨

public class MyBatisTest {
		
		@Inject
		private SqlSessionFactory sqlFactory;
		
		@Test
		public void testFactory(){
			
				System.out.println(sqlFactory);
		}
		
		@Test
		public void testSession()throws Exception{
			try (SqlSession session = sqlFactory.openSession()){
				System.out.println(session);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

