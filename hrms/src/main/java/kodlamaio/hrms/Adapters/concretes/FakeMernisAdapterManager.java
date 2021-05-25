package kodlamaio.hrms.Adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.Adapters.abstarcts.FakeMernisAdapterService;
import kodlamaio.hrms.entities.concretes.Candidate;
@Service
public class FakeMernisAdapterManager implements  FakeMernisAdapterService {

	@Override
	public boolean IfRealCheckPerson(Candidate candidate) {
		
		return true;
	}

}
