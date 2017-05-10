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
public class RetrieveAllEmployeeTask extends PragmaticBookselfTask<List<EmployeeEntity>> {

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
		/*
		 * we created instance of EmployeeStorageManager and called method
		 * retrieveAllEmployeeData
		 */
		List<EmployeeEntity> employeeData = EmployeeStorageManager.getInstance().retrieveAllEmployeeData(context);
		/*
		 * we created return result.
		 */
		PragmaticBookSelfResult<List<EmployeeEntity>> pragmaticBookSelfResult = new PragmaticBookSelfResult<List<EmployeeEntity>>();
		/*
		 * setted result data
		 */
		pragmaticBookSelfResult.setRestltedObject(employeeData);
		/*
		 * setted result code.
		 */
		pragmaticBookSelfResult.setResultCode(new ResultCode(ResultCodes.SUCCESSFUL));
		/*
		 * returning result
		 */
		return pragmaticBookSelfResult;
	}

}
