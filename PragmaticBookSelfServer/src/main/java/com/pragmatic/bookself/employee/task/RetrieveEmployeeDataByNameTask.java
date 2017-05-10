/**
 * 
 * Copyright *
 *
 */
package com.pragmatic.bookself.employee.task;

import java.util.List;

import com.pragmatic.bookself.employee.EmployeeEntity;
import com.pragmatic.bookself.employee.EmployeeStorageManager;
import com.pragmatic.bookself.exception.PragmaticBookSelfException;
import com.pragmatic.bookself.result.PragmaticBookSelfResult;
import com.pragmatic.bookself.result.ResultCode;
import com.pragmatic.bookself.result.ResultCode.ResultCodes;
import com.pragmatic.bookself.session.PragmaticBookselfSession;
import com.pragmatic.bookself.storagecontext.StorageContext;
import com.pragmatic.bookself.task.core.PragmaticBookselfTask;

/**
 * @author krishna
 *
 * @version 1.0
 */
public class RetrieveEmployeeDataByNameTask extends PragmaticBookselfTask<List<EmployeeEntity>> {
	private String name;

	public RetrieveEmployeeDataByNameTask(String fname) {
		this.name = fname;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.pragamtic.bookself.task.core.PragmaticBookselfTask#validateParameter(
	 * com.pragmatic.bookself.session.PragmaticBookselfSession,
	 * com.pragmatic.bookself.storagecontext.StorageContext)
	 */
	@Override
	protected void validateParameter(PragmaticBookselfSession session, StorageContext context)
			throws PragmaticBookSelfException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pragamtic.bookself.task.core.PragmaticBookselfTask#execute(com.
	 * pragmatic.bookself.session.PragmaticBookselfSession,
	 * com.pragmatic.bookself.storagecontext.StorageContext)
	 */
	@Override
	protected PragmaticBookSelfResult<List<EmployeeEntity>> execute(PragmaticBookselfSession session,
			StorageContext context) throws PragmaticBookSelfException {
		PragmaticBookSelfResult<List<EmployeeEntity>> result = new PragmaticBookSelfResult<List<EmployeeEntity>>();
		EmployeeStorageManager.getInstance().getEmployeeDataByName(name, context);
		List<EmployeeEntity> employeeEntityList = EmployeeStorageManager.getInstance().getEmployeeDataByName(name,
				context);
		result.setRestltedObject(employeeEntityList);
		result.setResultCode(new ResultCode(ResultCodes.SUCCESSFUL));

		return result;
	}

}
